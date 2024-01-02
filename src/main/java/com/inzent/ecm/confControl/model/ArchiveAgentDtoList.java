package com.inzent.ecm.confControl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ArchiveAgentDtoList {

	public List<ArchiveAgentDto> archiveAgentDtos ;

	
	public ArchiveAgentDtoList() {
		this.archiveAgentDtos = new ArrayList<>();
	}
	
	public List<ArchiveAgentDto> getArchiveAgentDtos() {
		return archiveAgentDtos;
	}

	public void setArchiveAgentDtos(List<ArchiveAgentDto> archiveAgentDtos) {
		this.archiveAgentDtos = archiveAgentDtos;
	}
}
