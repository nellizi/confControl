package com.inzent.ecm.confControl.service;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;
import com.inzent.ecm.confControl.model.CommAgentDto;
import com.inzent.ecm.confControl.model.DataAgentDto;
import com.inzent.ecm.confControl.model.LocalAgentDto;
import com.inzent.ecm.confControl.model.ServerDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateXML {

	public void createXML(ServerDto serverDto, List<ArchiveAgentDto> archiveAgentDtoList, CommAgentDto commDto,
			DataAgentDto dataDto, LocalAgentDto localDto, String dirName, String foldName) throws ParserConfigurationException, TransformerException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		document.setXmlStandalone(true);

		Element xvarm = document.createElement("XVARM");
		document.appendChild(xvarm);

		// Server
		Element server = document.createElement("server");
		server.setAttribute("keepperfstats", serverDto.getSe_keepperfstats());
		server.setAttribute("basemsg", serverDto.getSe_basemsg());

		Element logWriter = document.createElement("logwriter");
		logWriter.setAttribute("class", serverDto.getLo_Class());
		logWriter.setAttribute("level", serverDto.getLo_Level());

		Element property = document.createElement("property");
		property.setAttribute("name", serverDto.getPo_Name());
		System.out.println(serverDto.getPo_Name());
		property.setAttribute("section", serverDto.getPo_Section());

		Element localAgent = document.createElement("localagents");
		localAgent.setAttribute("machineid", localDto.getMachineId());
		xvarm.appendChild(server);
		xvarm.appendChild(localAgent);

		// server append
		server.appendChild(logWriter);
		logWriter.appendChild(property);

		// comm

		Element Cagent = document.createElement("agent");
		Cagent.setAttribute("name", commDto.getCag_Name());
		Cagent.setAttribute("type", commDto.getCag_Type());
		Cagent.setAttribute("class", commDto.getCag_Class());
		Cagent.setAttribute("opclass", commDto.getCag_Opclss());
		Cagent.setAttribute("msgfile", commDto.getCag_Msgfile());

		Element sockets = document.createElement("sockets");
		sockets.setAttribute("hostname", commDto.getSo_Hostname());
		sockets.setAttribute("port", commDto.getSo_Port());
		sockets.setAttribute("clienttimeout", commDto.getSo_ClientTimeOut());
		// comm append

		localAgent.appendChild(Cagent);
		Cagent.appendChild(sockets);

		// archive

		for (int i = 0; i < archiveAgentDtoList.size(); i++) {

			Element Aagent = document.createElement("agent");

			Aagent.setAttribute("name", archiveAgentDtoList.get(i).getAag_Name());
			Aagent.setAttribute("type", archiveAgentDtoList.get(i).getAag_Type());
			Aagent.setAttribute("desc", archiveAgentDtoList.get(i).getAag_Desc());
			Aagent.setAttribute("class", archiveAgentDtoList.get(i).getAag_class());
			Aagent.setAttribute("opclass", archiveAgentDtoList.get(i).getAag_Opclass());
			Aagent.setAttribute("msgfile", archiveAgentDtoList.get(i).getAag_Msgfile());

			Element sche = document.createElement("scheduler");
			sche.setAttribute("class", archiveAgentDtoList.get(i).getSc_class());

			Element devIf = document.createElement("deviceIF");
			devIf.setAttribute("class", archiveAgentDtoList.get(i).getDe_class());
			devIf.setAttribute("basedir", archiveAgentDtoList.get(i).getDe_Basedir());
			devIf.setAttribute("hashdirs", archiveAgentDtoList.get(i).getDe_Hashdirs());
			devIf.setAttribute("dateformat", archiveAgentDtoList.get(i).getDe_Dateformat());
			devIf.setAttribute("filesystemclass", archiveAgentDtoList.get(i).getDe_filesystemclass());
			devIf.setAttribute("filesystemkb", archiveAgentDtoList.get(i).getDe_filesystemkb());

			Element thrPool = document.createElement("threadpool");
			thrPool.setAttribute("ops", archiveAgentDtoList.get(i).getTh_Ops());
			thrPool.setAttribute("count", archiveAgentDtoList.get(i).getTh_Count());

			// archive append

			localAgent.appendChild(Aagent);
			Aagent.appendChild(sche);
			sche.appendChild(devIf);
			sche.appendChild(thrPool);

		}

		// data

		Element Dagent = document.createElement("agent");

		Dagent.setAttribute("name", dataDto.getDag_Name());
		Dagent.setAttribute("type", dataDto.getDag_Type());
		Dagent.setAttribute("class", dataDto.getDag_Class());
		Dagent.setAttribute("msgfile", dataDto.getDag_Msgfile());

		Element dbpools = document.createElement("dbpools");

		Element pool = document.createElement("pool");
		pool.setAttribute("name", dataDto.getDPo_Name());
		pool.setAttribute("driver", dataDto.getPo_Driver());
		pool.setAttribute("connect", dataDto.getPo_Connect());
		pool.setAttribute("dbtype", dataDto.getPo_Dbtype());
		pool.setAttribute("user", dataDto.getPo_User());
		pool.setAttribute("pswd", dataDto.getPo_Pswd());
		pool.setAttribute("count", dataDto.getPo_Count());
		pool.setAttribute("preconnect", dataDto.getPo_Preconnect());
		pool.setAttribute("unicode", dataDto.getPo_Unicode());

		Element startup = document.createElement("startup");
		startup.setAttribute("mainpool", dataDto.getSt_MainpoolString());
		startup.setAttribute("locasysime", dataDto.getSt_Locasysime());
		startup.setAttribute("retentionignore", dataDto.getSt_retentionignore());

		Element listspooler = document.createElement("listspooler");
		listspooler.setAttribute("listdir", dataDto.getLi_Listdir());
		listspooler.setAttribute("memcache", dataDto.getLi_Memcache());
		listspooler.setAttribute("timeout", dataDto.getLi_Timeout());

		Element phyvoleman = document.createElement("physicalvolumemanager");
		phyvoleman.setAttribute("iteration", dataDto.getPh_Iteration());
		phyvoleman.setAttribute("OnErrorReadOnly", dataDto.getPh_OnErrorReadOnly());

		Element activemanager = document.createElement("activemanager");
		activemanager.setAttribute("iteration", dataDto.getAc_Iteration());

		Element checkquery = document.createElement("checkquery");
		checkquery.setAttribute("CHECKQUERYENABLE", dataDto.getCh_CheckQueryEnable());
		checkquery.setAttribute("CHECKQUERYTIMEOUT", dataDto.getCh_CheckQueryEnable());
		checkquery.setAttribute("VALIDATIONINTERVAL", dataDto.getCh_Validationinterval());

		Element defaultaudit = document.createElement("defaultaudit");
		defaultaudit.setAttribute("agentserver", dataDto.getDe_Agentserver());
		defaultaudit.setAttribute("agentname", dataDto.getDe_AgentName());

		// farm 추가?

		// data append
		localAgent.appendChild(Dagent);
		Dagent.appendChild(dbpools);
		dbpools.appendChild(pool);
		Dagent.appendChild(startup);
		Dagent.appendChild(listspooler);
		Dagent.appendChild(phyvoleman);
		Dagent.appendChild(activemanager);
		Dagent.appendChild(checkquery);
		Dagent.appendChild(defaultaudit);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty("encoding", "UTF-8"); // setOutputProperty : 출력형태 만들 때 사용
		transformer.setOutputProperty("indent", "yes"); // indent : 들여쓰기
		transformer.setOutputProperty("doctype-public", "yes"); // document.setXmlStandalone(true); 하면 개행이 안 되기 때문에 추가

		Source source = new DOMSource(document);
		File dir = new File(dirName);
		if (!dir.exists()) {
			try {
				dir.mkdir();
				
			} catch (Exception e) {
				e.getStackTrace();
			}
		} else {
			System.out.println("폴더가 이미 존재합니다..");
			
		}
		File file = new File(dir, foldName+".xml");
		
	
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);
	}

}