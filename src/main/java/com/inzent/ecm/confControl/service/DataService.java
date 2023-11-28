package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Data");
	}

	public void getAttribute(Element ele) { // ele.getNodeName = agent
		// TODO Auto-generated method stub
		System.out.println("============3." + ele.getNodeName());
		System.out.println("name: " + ele.getAttribute("name"));
		System.out.println("class: " + ele.getAttribute("class"));

		NodeList childeren = ele.getChildNodes(); // childeren : agent

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2); // sockets

				switch (nodeName2) {
				case "dbpools":
					System.out.println("node name2: " + nodeName2);
					System.out.println("name: " + ele2.getAttribute("name"));
					break;
				case "startup":
					System.out.println("node name2: " + nodeName2);
					System.out.println("mainpool: " + ele2.getAttribute("mainpool"));
					break;
				case "listspooler":
					System.out.println("node name2: " + nodeName2);
					System.out.println("listdir: " + ele2.getAttribute("listdir"));
					break;
				case "physicalvolumemanager":
					System.out.println("node name2: " + nodeName2);
					System.out.println("iteration: " + ele2.getAttribute("iteration"));
					break;
				case "activemanager":
					System.out.println("node name2: " + nodeName2);
					System.out.println("iteration: " + ele2.getAttribute("iteration"));
					break;
				case "checkquery":
					System.out.println("node name2: " + nodeName2);
					System.out.println("CHECKQUERYENABLE: " + ele2.getAttribute("CHECKQUERYENABLE"));
					break;
				case "defaultaudit":
					System.out.println("node name2: " + nodeName2);
					System.out.println("agentserver: " + ele2.getAttribute("agentserver"));
					break;
					
				}
			}

			NodeList childeren2 = node2.getChildNodes();
			for (int i = 0; i < childeren2.getLength(); i++) {
				Node node3 = childeren2.item(i);
				if (node3.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node3;
					String nodeName3 = ele3.getNodeName();
					System.out.println("node name3: " + nodeName3); // pool

					System.out.println("name: " + ele3.getAttribute("name"));
					System.out.println("driver: " + ele3.getAttribute("driver"));
					System.out.println("connect: " + ele3.getAttribute("connect"));
					System.out.println("dbtype: " + ele3.getAttribute("dbtype"));
					System.out.println("user: " + ele3.getAttribute("user"));
					System.out.println("pswd: " + ele3.getAttribute("pswd"));
					System.out.println("count: " + ele3.getAttribute("count"));
					System.out.println("preconnect: " + ele3.getAttribute("preconnect"));
					System.out.println("unicode: " + ele3.getAttribute("unicode"));

				}
			}

		}
	}

}
