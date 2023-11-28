package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerService {

	public void getAttribute(Element ele) { // ele.getNodeName = SERVER
		// TODO Auto-generated method stub
		System.out.println(ele.getNodeName()); //server
		System.out.println("keepperfstats : " + ele.getAttribute("keepperfstats"));
		System.out.println("basemsg: " + ele.getAttribute("basemsg"));

		NodeList childeren = ele.getChildNodes(); // SEVER의 자식 element 구하기 -> logwriter

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node = childeren.item(a);  //node2 = logwriter
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node;
				String nodeName = ele2.getNodeName();
				System.out.println("node name: " + nodeName);
				System.out.println("class: " + ele2.getAttribute("class"));
				System.out.println("level: " + ele2.getAttribute("level"));
			}

			NodeList childeren2 = node.getChildNodes();
			for (int i = 0; i < childeren2.getLength(); i++) {
				Node node2 = childeren2.item(i);
				if (node2.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node2;
					String nodeName2 = ele3.getNodeName();
					System.out.println("node name2: " + nodeName2);
					System.out.println("name: " + ele3.getAttribute("name"));
					System.out.println("section: " + ele3.getAttribute("section"));

				}
			}

		}

	}
}
