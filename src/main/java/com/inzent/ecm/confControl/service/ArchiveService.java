package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArchiveService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("archive");
	}

	public ArchiveAgentDto getAttribute(Element ele) { // ele.getNodeName = agent    -> type이 archive인 agent만 받음
		
		ArchiveAgentDto archive =new ArchiveAgentDto();
		// TODO Auto-generated method stub
		System.out.println("============2." + ele.getNodeName());
		
		archive.setAg_Name(ele.getAttribute("name"));
		archive.setAg_Type(ele.getAttribute("type"));
		archive.setAg_Desc(ele.getAttribute("desc"));
		archive.setAg_class(ele.getAttribute("class"));
		archive.setAg_Opclass(ele.getAttribute("opclass"));
		archive.setAg_Msgfile(ele.getAttribute("msgfile"));

		NodeList childeren = ele.getChildNodes(); // archiveAgent에는 자식element인 scheduler 존재

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);   
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2); // scheduler
				archive.setSc_class(ele2.getAttribute("class"));
				

			}

			NodeList childeren2 = node2.getChildNodes();   //node2 = scheduler -> scheduler의 자식 element 구하기 
			for (int i = 0; i < childeren2.getLength(); i++) {
				Node node3 = childeren2.item(i);
				if (node3.getNodeType() == Node.ELEMENT_NODE) {
					Element ele3 = (Element) node3;
					String nodeName3 = ele3.getNodeName(); // 1. deviceIF, 2.threadpool
					

					switch (nodeName3) {
					case "deviceIF":
						System.out.println("node name3: " + nodeName3);
						
						archive.setDe_class(ele3.getAttribute("class"));
						archive.setDe_Basedir(ele3.getAttribute("basedir"));
						archive.setDe_Hashdirs(ele3.getAttribute("hashdirs"));
						archive.setDe_Dateformat(ele3.getAttribute("dateformat"));
						archive.setDe_filesystemclass(ele3.getAttribute("filesystemclass"));
						archive.setDe_filesystemkb(ele3.getAttribute("filesystemkb"));
						break;
					case "threadpool":
						System.out.println("node name3: " + nodeName3);
						archive.setTh_Ops(ele3.getAttribute("ops"));
						archive.setTh_Count(ele3.getAttribute("count"));
						break;

					}

				}
			}

		}
		
		return archive;
		
	}

}
