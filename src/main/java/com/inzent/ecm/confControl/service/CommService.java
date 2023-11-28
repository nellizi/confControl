package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("comm");
	}

	public void getAttribute(Element ele) { // ele.getNodeName = agent
		// TODO Auto-generated method stub
		System.out.println("============1." + ele.getNodeName());
		System.out.println("name: " + ele.getAttribute("name"));
		System.out.println("class: " + ele.getAttribute("class"));

		NodeList childeren = ele.getChildNodes(); // childeren : agent
		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2); // sockets

			}

		}
	}

}
