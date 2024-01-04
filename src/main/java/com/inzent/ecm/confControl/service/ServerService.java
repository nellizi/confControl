package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.ServerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerService {

	public ServerDto getAttribute(Element ele) { // ele.getNodeName = SERVER

		ServerDto server = new ServerDto();

		server.setSe_keepperfstats(ele.getAttribute("keepperfstats"));
		server.setSe_basemsg(ele.getAttribute("basemsg"));

		NodeList childeren = ele.getChildNodes(); // SEVER의 자식 element 구하기 -> logwriter

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node = childeren.item(a); // node2 = logwriter
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node;
//				String nodeName = ele2.getNodeName();
				server.setLo_Class(ele2.getAttribute("class"));
				server.setLo_Level(ele2.getAttribute("level"));
			}

			NodeList childeren2 = node.getChildNodes();
			for (int i = 0; i < childeren2.getLength(); i++) {
				Node node2 = childeren2.item(i);
				if (node2.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node2;
//					String nodeName2 = ele3.getNodeName();
					server.setPo_Name(ele3.getAttribute("name"));
					server.setPo_Section(ele3.getAttribute("section"));

				}
			}

		}
		return server;
	}
}
