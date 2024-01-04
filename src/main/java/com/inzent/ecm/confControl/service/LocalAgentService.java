package com.inzent.ecm.confControl.service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inzent.ecm.confControl.model.LocalAgentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LocalAgentService {

	public LocalAgentDto getAttribute(Element ele) {

		LocalAgentDto local = new LocalAgentDto();

		local.setMachineId(ele.getAttribute("machineid"));

		return local;

	}

}
