package com.inzent.ecm.confControl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ArchiveAgentDto {
	
	private String ag_Name;
	
	private String ag_Type;
	
	private String ag_Desc;
	
	private String ag_class;
	
	private String ag_Opclass;
	
	private String ag_Msgfile;
	
	private String sc_class;
	
	private String de_class;
	
	private String de_Basedir;
	
	private String de_Hashdirs;
	
	private String de_Dateformat;
	
	private String de_filesystemclass;
	
	private String de_filesystemkb;
	
	private String th_Ops;
	
	private String th_Count;
	
	
	
	

}
