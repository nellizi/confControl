package com.inzent.ecm.confControl.service;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;
import com.inzent.ecm.confControl.model.CommAgentDto;
import com.inzent.ecm.confControl.model.DataAgentDto;
import com.inzent.ecm.confControl.model.LocalAgentDto;
import com.inzent.ecm.confControl.model.ServerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateXML {
	
	public void createXML(ServerDto serverDto, ArchiveAgentDto arcAgentDto, CommAgentDto commDto, DataAgentDto dataDto, LocalAgentDto localDto) throws ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		document.setXmlStandalone(true);  
		
		Element xvarm = document.createElement("XVARM");
		document.appendChild(xvarm);
		
		//Server
		Element server = document.createElement("server");
		server.setAttribute("keepperfstats", serverDto.getSe_keepperfstats());
		server.setAttribute("basemsg", serverDto.getSe_basemsg());
		
		
		Element logWriter = document.createElement("logwriter");
		logWriter.setAttribute("class", serverDto.getLo_Class());
		logWriter.setAttribute("level", serverDto.getLo_Level());
		
		Element property = document.createElement("property");
		property.setAttribute("name", serverDto.getPo_Name());
		System.out.println(serverDto.getPo_Name());
		property.setAttribute("section", serverDto.getPo_Section());
		
		Element localAgent = document.createElement("localAgent");
		localAgent.setAttribute("machineid", localDto.getMachineId());
		xvarm.appendChild(server);
		xvarm.appendChild(localAgent);
		
		
		//comm
		
		Element agent = document.createElement("agent");
		agent.setAttribute("name", commDto.getAg_Name());
		agent.setAttribute("class", commDto.getAg_Class());
		agent.setAttribute("opclass", commDto.getAg_Opclss());
		agent.setAttribute("msgfile", commDto.getAg_Msgfile());
		
		Element sockets = document.createElement("sockets");
		sockets.setAttribute("hostname", commDto.getSo_Hostname());
		sockets.setAttribute("port", commDto.getSo_Port());
		sockets.setAttribute("clienttimeout", commDto.getSo_ClientTimeOut());
		
		
		
		
		//server append
		server.appendChild(logWriter);
		logWriter.appendChild(property);
		
		//comm append
		localAgent.appendChild(agent);
		agent.appendChild(sockets);
		
		
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty("encoding", "UTF-8");  // setOutputProperty  : 출력형태 만들 때 사용
		transformer.setOutputProperty("indent", "yes");  // indent  : 들여쓰기
		transformer.setOutputProperty("doctype-public", "yes");  // document.setXmlStandalone(true); 하면 개행이 안 되기 때문에 추가
		
		Source source = new DOMSource(document);
		File file = new File("C:\\test", "conf.xml");
		StreamResult result = new StreamResult(file);
		
		

		transformer.transform(source, result);
		
		
		
	}
	
}
