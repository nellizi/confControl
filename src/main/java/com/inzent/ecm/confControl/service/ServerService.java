package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerService {

	public void test() {
		// TODO Auto-generated method stub
			System.out.println("server");		
	}

	public void getAttribute(Element ele) {
		// TODO Auto-generated method stub
		
		System.out.println("~~~~~node attribute: " + ele.getAttribute("keepperfstats"));
		System.out.println("~~~~~node attribute: " + ele.getAttribute("basemsg"));
		NodeList childeren2 = ele.getChildNodes();
		for (int a = 0; a < childeren2.getLength(); a++) {
			Node node2 = childeren2.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2);
				System.out.println("node attribute2: " + ele2.getAttribute("class"));
			}
		}
		
	}

	
}
