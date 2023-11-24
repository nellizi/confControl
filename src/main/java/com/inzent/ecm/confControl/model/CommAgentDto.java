package com.inzent.ecm.confControl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommAgentDto {

	private String ag_Name;
	
	private String ag_Type;
	
	private String ag_Class;
	
	private String ag_Opclss;
	
	private String ag_Msgfile;
	
	private String so_Hostname;
	
	private String so_Port;
	
	private String so_ClientTimeOut;
	
	
}
