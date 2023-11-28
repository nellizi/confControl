package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArchiveService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("archive");
	}

	public void getAttribute(Element ele) { // ele.getNodeName = agent
		// TODO Auto-generated method stub
		System.out.println("============2." + ele.getNodeName());
		System.out.println("name: " + ele.getAttribute("name"));
		System.out.println("type: " + ele.getAttribute("type"));
		System.out.println("desc: " + ele.getAttribute("desc"));
		System.out.println("class: " + ele.getAttribute("class"));
		System.out.println("opclass: " + ele.getAttribute("opclass"));
		System.out.println("msgfile: " + ele.getAttribute("msgfile"));

		NodeList childeren = ele.getChildNodes(); // childeren : agent

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2); // scheduler
				System.out.println("class: " + ele2.getAttribute("class"));
				System.out.println("=================1====================");

			}

			NodeList childeren2 = node2.getChildNodes();
			for (int i = 0; i < childeren2.getLength(); i++) {
				Node node3 = childeren2.item(i);
				if (node3.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node3;
					String nodeName3 = ele3.getNodeName(); // 1. deviceIF, 2.threadpool

					switch (nodeName3) {
					case "deviceIF":
						System.out.println("node name3: " + nodeName3);
						System.out.println("class: " + ele3.getAttribute("class"));
						System.out.println("basedir: " + ele3.getAttribute("basedir"));
						System.out.println("hashdirs: " + ele3.getAttribute("hashdirs"));
						System.out.println("=================2====================");
						break;
					case "threadpool":
						System.out.println("node name3: " + nodeName3);
						System.out.println("ops: " + ele3.getAttribute("ops"));
						System.out.println("count: " + ele3.getAttribute("count"));
						System.out.println("=================3====================");
						break;

					}

				}
			}

		}
	}

}
