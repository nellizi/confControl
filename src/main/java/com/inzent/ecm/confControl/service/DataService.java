package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.DataAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataService {

	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Data");
	}

	public DataAgentDto getAttribute(Element ele) { // ele.getNodeName = agent
		
		DataAgentDto data = new DataAgentDto();
		// TODO Auto-generated method stub
		System.out.println("============3." + ele.getNodeName());   //agent
		
		data.setAg_Name(ele.getAttribute("name"));
		data.setAg_Type(ele.getAttribute("type"));		
		data.setAg_Class(ele.getAttribute("class"));
		data.setAg_Msgfile(ele.getAttribute("msgfile"));

		NodeList childeren = ele.getChildNodes(); // childeren : agent

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("--------node name2: " + nodeName2); // sockets

				switch (nodeName2) {
				case "dbpools":		
					System.out.println("name: " + ele2.getAttribute("name"));
					break;
				case "startup":
					data.setSt_MainpoolString(ele2.getAttribute("mainpool"));
					data.setSt_Locasysime(ele2.getAttribute("locasysime"));
					data.setSt_retentionignore(ele2.getAttribute("retentionignore"));
					break;
				case "listspooler":
					data.setLi_Lisrdir(ele2.getAttribute("listdir"));
					data.setLi_Memcache(ele2.getAttribute("memcache"));
					data.setLi_Timeout(ele2.getAttribute("timeout"));
					break;
				case "physicalvolumemanager":
					data.setPh_Iteration(ele2.getAttribute("iteration"));
					data.setPh_OnErrorReadOnly(ele2.getAttribute("OnErrorReadOnly"));
					break;
				case "activemanager":
					data.setAc_Iteration(ele2.getAttribute("iteration"));
					break;
				case "checkquery":
					data.setCh_CheckQueryEnable( ele2.getAttribute("CHECKQUERYENABLE"));
					data.setCh_SheckQueryTimeout( ele2.getAttribute("CHECKQUERYTIMEOUT"));
					data.setCh_Validationinterval( ele2.getAttribute("VALIDATIONINTERVAL"));
					break;
				case "defaultaudit":
					data.setDe_Agentserver(ele2.getAttribute("agentserver"));
					data.setDe_AgentName(ele2.getAttribute("agentname"));
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
				
					data.setPo_Name(ele3.getAttribute("name"));
					data.setPo_Driver(ele3.getAttribute("driver"));
					data.setPo_Connect(ele3.getAttribute("connect"));
					data.setPo_Dbtype(ele3.getAttribute("dbtype"));
					data.setPo_User(ele3.getAttribute("user"));
					data.setPo_Pswd(ele3.getAttribute("pswd"));
					data.setPo_Count(ele3.getAttribute("count"));
					data.setPo_Preconnect(ele3.getAttribute("preconnect"));
					data.setPo_Unicode(ele3.getAttribute("unicode"));
	
				}
			}

		}
		
		return data;
		
	}

}
