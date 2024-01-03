package com.inzent.ecm.confControl.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@Setter
@Getter
public class AgentDtoList {
	
	private List<ArchiveAgentDto> archiveAgentDtos = new ArrayList<>();
	
	private List<CommAgentDto> commAgentDtos  = new ArrayList<>();
	
	private List<DataAgentDto> dataAgentDtoas = new ArrayList<>();
	
	private List<ServerDto> serverDtos = new ArrayList<>();
	
	private List<LocalAgentDto> localAgentDtos = new ArrayList<>();

	public List<ArchiveAgentDto> getArchiveAgentDtos() {
		return archiveAgentDtos;
	}

	public void setArchiveAgentDtos(List<ArchiveAgentDto> archiveAgentDtos) {
		this.archiveAgentDtos = archiveAgentDtos;
	}

	public List<CommAgentDto> getCommAgentDtos() {
		return commAgentDtos;
	}

	public void setCommAgentDtos(List<CommAgentDto> commAgentDtos) {
		this.commAgentDtos = commAgentDtos;
	}

	public List<DataAgentDto> getDataAgentDtoas() {
		return dataAgentDtoas;
	}

	public void setDataAgentDtoas(List<DataAgentDto> dataAgentDtoas) {
		this.dataAgentDtoas = dataAgentDtoas;
	}

	public List<ServerDto> getServerDtos() {
		return serverDtos;
	}

	public void setServerDtos(List<ServerDto> serverDtos) {
		this.serverDtos = serverDtos;
	}

	public List<LocalAgentDto> getLocalAgentDtos() {
		return localAgentDtos;
	}

	public void setLocalAgentDtos(List<LocalAgentDto> localAgentDtos) {
		this.localAgentDtos = localAgentDtos;
	}
	

}
