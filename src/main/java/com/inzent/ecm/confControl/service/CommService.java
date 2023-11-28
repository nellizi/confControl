package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.CommAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("comm");
	}

	public CommAgentDto getAttribute(Element ele) { // ele.getNodeName = agent
		
		CommAgentDto comm = new CommAgentDto();
		// TODO Auto-generated method stub
		System.out.println("============1." + ele.getNodeName());
		
		comm.setAg_Name(ele.getAttribute("name"));
		comm.setAg_Type(ele.getAttribute("type"));
		comm.setAg_Class(ele.getAttribute("class"));
		comm.setAg_Opclss(ele.getAttribute("opclass"));
		comm.setAg_Msgfile(ele.getAttribute("msgfile"));
		
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
