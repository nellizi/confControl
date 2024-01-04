package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.CommAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommService {

	public CommAgentDto getAttribute(Element ele) { // ele.getNodeName = agent
		
		CommAgentDto comm = new CommAgentDto();
		System.out.println("============1." + ele.getNodeName());
		
		comm.setCag_Name(ele.getAttribute("name"));
		comm.setCag_Type(ele.getAttribute("type"));
		comm.setCag_Class(ele.getAttribute("class"));
		comm.setCag_Opclss(ele.getAttribute("opclass"));
		comm.setCag_Msgfile(ele.getAttribute("msgfile"));
		
		NodeList childeren = ele.getChildNodes(); // childeren : agent
		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				comm.setSo_Hostname(ele2.getAttribute("hostname"));
				comm.setSo_Port(ele2.getAttribute("port"));
				comm.setSo_ClientTimeOut(ele2.getAttribute("clienttimeout"));
				
			}

		}
		
		return comm;
	}

}
