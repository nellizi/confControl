package com.inzent.ecm.confControl.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;
import com.inzent.ecm.confControl.model.CommAgentDto;
import com.inzent.ecm.confControl.model.DataAgentDto;
import com.inzent.ecm.confControl.model.LocalAgentDto;
import com.inzent.ecm.confControl.model.ServerDto;
import com.inzent.ecm.confControl.service.ArchiveService;
import com.inzent.ecm.confControl.service.CommService;
import com.inzent.ecm.confControl.service.CreateXML;
import com.inzent.ecm.confControl.service.DataService;
import com.inzent.ecm.confControl.service.Delete;
import com.inzent.ecm.confControl.service.LocalAgentService;
import com.inzent.ecm.confControl.service.MakeDir;
import com.inzent.ecm.confControl.service.ServerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final ArchiveService archiveService;
	private final CommService commService;
	private final DataService dataService;
	private final ServerService serverService;
	private final LocalAgentService localService;
	private final CreateXML createXML;
	private final Delete delete; 
	private final MakeDir makeDir;

	public MainController(ArchiveService archiveService, CommService commService, DataService dataService,
			ServerService serverService, LocalAgentService localService, CreateXML createXML, Delete delete, MakeDir makeDir) {
		this.archiveService = archiveService;
		this.commService = commService;
		this.dataService = dataService;
		this.serverService = serverService;
		this.localService = localService;
		this.createXML = createXML;
		this.delete = delete;
		this.makeDir = makeDir;

	}

	@GetMapping("/main")
	public String test() {

		return "/main";
	}
	

	
	@PostMapping("/parse")
	public String domPaser(Model model, @RequestParam MultipartFile file)
			throws ParserConfigurationException, SAXException, IOException {
		

		CommAgentDto comm = null;
		ArchiveAgentDto archive = null;
		DataAgentDto data = null;
		List<ArchiveAgentDto> archiveList = new ArrayList<>();
		File path = makeDir.makeDir();

		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		File requestFile = new File(path+"/" + UUID.randomUUID().toString());// 임시로 파일 생성
		file.transferTo(requestFile);// 파일로 변환
		System.out.println(file);
		Document document = documentBuilder.parse(requestFile.getAbsoluteFile());

		// root 구하기 <XVARM>
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName()); // XVARM

		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get

		 
		
		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i); // 1. server, 2. localagents

			if (node.getNodeType() == Node.ELEMENT_NODE) { // 해당 노드의 종류 판정(Element일 때) *XVARM은 root, 하위 태그들이 element ->
															// XVARM 태그 걸러내기
				Element ele = (Element) node;
				String nodeName = ele.getNodeName(); // element 노드 이름 구하기 (첫번째 태그 값) 1.server, 2.localagents
				if (nodeName.equals("server")) {
					ServerDto server = serverService.getAttribute(ele);
					model.addAttribute("server", server);
					
				} else if (nodeName.equals("localagents")) { // localAgent 시작, localAgent는 type별로 구분 필요
					LocalAgentDto local = localService.getAttribute(ele);
					model.addAttribute("local", local);
					NodeList childeren2 = ele.getChildNodes(); // localAgent 자식 element 구하기
					for (int a = 0; a < childeren2.getLength(); a++) {
						Node node2 = childeren2.item(a); // childeren2 -> { 1. comm, 2. archive, 3. data }
						if (node2.getNodeType() == Node.ELEMENT_NODE) { // 각 agent 속성값 중 type으로 구분해서 불러오기
							Element ele2 = (Element) node2;
							String type = ele2.getAttribute("type");

							switch (type) {
							case "COMM":
								comm = commService.getAttribute(ele2);

								model.addAttribute("comm", comm);

								break;
							case "ARCHIVE":
								archive = archiveService.getAttribute(ele2);
								archiveList.add(archive);
								model.addAttribute("archiveList", archiveList);
								break;
							case "DATA":
								data = dataService.getAttribute(ele2);
								
								model.addAttribute("data", data);
								break;
							}

							
						}
						
					}
				}
			}
			
		}
		
		  delete.DeleteFile(requestFile);
		  delete.DeleteFile(path);
		 


		return "newTest2";
		
	}
	
	
	@GetMapping("/create")
	String createXml(@ModelAttribute ServerDto serverDto, @ModelAttribute ArchiveAgentDto arcAgentDto,
			@ModelAttribute CommAgentDto CommDto, @ModelAttribute DataAgentDto dataDto,
			@ModelAttribute LocalAgentDto localDto, @RequestParam String dirName, @RequestParam String foldName
			) throws ParserConfigurationException, TransformerException {
			createXML.createXML(serverDto, arcAgentDto, CommDto, dataDto, localDto, dirName, foldName);
			
						
		return "main";
	}
	
	

}
