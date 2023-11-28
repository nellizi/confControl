package com.inzent.ecm.confControl.controller;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;
import com.inzent.ecm.confControl.model.CommAgentDto;
import com.inzent.ecm.confControl.model.DataAgentDto;
import com.inzent.ecm.confControl.model.ServerDto;
import com.inzent.ecm.confControl.service.ArchiveService;
import com.inzent.ecm.confControl.service.CommService;
import com.inzent.ecm.confControl.service.DataService;
import com.inzent.ecm.confControl.service.ServerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final ArchiveService archiveService;
	private final CommService commService;
	private final DataService dataService;
	private final ServerService serverService;

	public MainController(ArchiveService archiveService, CommService commService, DataService dataService,
			ServerService serverService) {
		this.archiveService = archiveService;
		this.commService = commService;
		this.dataService = dataService;
		this.serverService = serverService;
	}

	@GetMapping("/main")
	public String test() {

		return "/main";
	}

	@GetMapping("/detail")
	public String detial() {

		return "/detail";
	}

	@GetMapping("/parse")
	public String domPaser() throws ParserConfigurationException, SAXException, IOException {
		
		CommAgentDto comm = null;
		ArchiveAgentDto archive = null;
		DataAgentDto data = null;
		
		// XML 문서 파싱
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("xml/conf.xml"); // file 불러오기로 수정

		// root 구하기 <XVARM>
		Element root = document.getDocumentElement();
	    System.out.println(root.getNodeName());   //XVARM

		NodeList childeren = root.getChildNodes(); // 자식 노드 목록 get

		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i); // 1. server, 2. localagents

			if (node.getNodeType() == Node.ELEMENT_NODE) { // 해당 노드의 종류 판정(Element일 때) *XVARM은 root, 하위 태그들이 element ->
															// XVARM 태그 걸러내기
				Element ele = (Element) node;
				String nodeName = ele.getNodeName(); // element 노드 이름 구하기 (첫번째 태그 값) 1.server, 2.localagents
				if (nodeName.equals("server")) {
					ServerDto server =serverService.getAttribute(ele);
				} else if (nodeName.equals("localagents")) { // localAgent 시작, localAgent는 type별로 구분 필요
					NodeList childeren2 = ele.getChildNodes(); // localAgent 자식 element 구하기
					for (int a = 0; a < childeren2.getLength(); a++) {
						Node node2 = childeren2.item(a); // childeren2 -> { 1. comm, 2. archive, 3. data }
						if (node2.getNodeType() == Node.ELEMENT_NODE) { // 각 agent 속성값 중 type으로 구분해서 불러오기
							Element ele2 = (Element) node2;
							String type = ele2.getAttribute("type");

							switch (type) {
							case "COMM":
								 comm = commService.getAttribute(ele2);
								break;
							case "ARCHIVE":
								 archive = archiveService.getAttribute(ele2);
								break;
							case "DATA":
								 data = dataService.getAttribute(ele2);
								break;
							}
						}
					}
				}
			}
		}
		
		return null;
	}

}
