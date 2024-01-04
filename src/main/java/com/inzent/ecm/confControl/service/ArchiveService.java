package com.inzent.ecm.confControl.service;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.ArchiveAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArchiveService {
	public ArchiveAgentDto getAttribute(Element ele) { // ele.getNodeName = agent -> type이 archive인 agent만 받음

		ArchiveAgentDto archive = new ArchiveAgentDto();
		System.out.println("============2." + ele.getNodeName());

		archive.setAag_Name(ele.getAttribute("name"));
		archive.setAag_Type(ele.getAttribute("type"));
		archive.setAag_Desc(ele.getAttribute("desc"));
		archive.setAag_class(ele.getAttribute("class"));
		archive.setAag_Opclass(ele.getAttribute("opclass"));
		archive.setAag_Msgfile(ele.getAttribute("msgfile"));

		NodeList childeren = ele.getChildNodes(); // archiveAgent에는 자식element인 scheduler 존재

		for (int a = 0; a < childeren.getLength(); a++) {
			Node node2 = childeren.item(a);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {
				Element ele2 = (Element) node2;
				String nodeName2 = ele2.getNodeName();
				System.out.println("node name2: " + nodeName2); // scheduler
				archive.setSc_class(ele2.getAttribute("class"));

			}

			NodeList childeren2 = node2.getChildNodes(); // node2 = scheduler -> scheduler의 자식 element 구하기
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

	public List<ArchiveAgentDto> splitAgentDto(ArchiveAgentDto arcAgentDto) {

		List<ArchiveAgentDto> archiveAgentDtoList = new ArrayList<>();

		String Aag_NameString = arcAgentDto.getAag_Name();
		String Aag_Type = arcAgentDto.getAag_Type();
		String Aag_Desc = arcAgentDto.getAag_Desc();
		String Aag_class = arcAgentDto.getAag_class();
		String Aag_Opclass = arcAgentDto.getAag_Opclass();
		String Aag_Msgfile = arcAgentDto.getAag_Msgfile();
		String sc_class = arcAgentDto.getSc_class();
		String de_class = arcAgentDto.getDe_class();
		String de_Basedir = arcAgentDto.getDe_Basedir();
		String de_Hashdirs = arcAgentDto.getDe_Hashdirs();
		String de_Dateformat = arcAgentDto.getDe_Dateformat();
		String de_filesystemclass = arcAgentDto.getDe_filesystemclass();
		String de_filesystemkb = arcAgentDto.getDe_filesystemkb();
		String th_Ops = arcAgentDto.getTh_Ops();
		String th_Count = arcAgentDto.getTh_Count();

		String[] Aag_NameArr = Aag_NameString.split(",");
		String[] Aag_TypeArr = Aag_Type.split(",");
		String[] Aag_DescArr = Aag_Desc.split(",");
		String[] Aag_classArr = Aag_class.split(",");
		String[] Aag_OpclassArr = Aag_Opclass.split(",");
		String[] Aag_MsgfileArr = Aag_Msgfile.split(",");
		String[] sc_classArr = sc_class.split(",");
		String[] de_classArr = de_class.split(",");
		String[] de_BasedirArr = de_Basedir.split(",");
		String[] de_HashdirsArr = de_Hashdirs.split(",");
		String[] de_DateformatArr = de_Dateformat.split(",");
		String[] de_filesystemclassArr = de_filesystemclass.split(",");
		String[] de_filesystemkbArr = de_filesystemkb.split(",");
		String[] th_OpsArr = th_Ops.split(",");
		String[] th_CountArr = th_Count.split(",");

		for (int i = 0; i < Aag_NameArr.length; i++) {
			ArchiveAgentDto archive = new ArchiveAgentDto();
			archive.setAag_class(Aag_classArr[i]);
			archive.setAag_Desc(Aag_DescArr[i]);
			archive.setAag_Msgfile(Aag_MsgfileArr[i]);
			archive.setAag_Name(Aag_NameArr[i]);
			archive.setAag_Opclass(Aag_OpclassArr[i]);
			archive.setAag_Type(Aag_TypeArr[i]);
			archive.setDe_Basedir(de_BasedirArr[i]);
			archive.setDe_class(de_classArr[i]);
			archive.setDe_Dateformat(de_DateformatArr[i]);
			archive.setDe_filesystemclass(de_filesystemclassArr[i]);
			archive.setDe_filesystemkb(de_filesystemkbArr[i]);
			archive.setDe_Hashdirs(de_HashdirsArr[i]);
			archive.setSc_class(sc_classArr[i]);
			archive.setTh_Count(th_CountArr[i]);
			archive.setTh_Ops(th_OpsArr[i]);

			archiveAgentDtoList.add(archive);

		}
		return archiveAgentDtoList;
	}

}