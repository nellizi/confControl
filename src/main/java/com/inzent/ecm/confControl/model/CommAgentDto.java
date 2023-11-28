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

	public String getAg_Name() {
		return ag_Name;
	}

	public void setAg_Name(String ag_Name) {
		this.ag_Name = ag_Name;
	}

	public String getAg_Type() {
		return ag_Type;
	}

	public void setAg_Type(String ag_Type) {
		this.ag_Type = ag_Type;
	}

	public String getAg_Class() {
		return ag_Class;
	}

	public void setAg_Class(String ag_Class) {
		this.ag_Class = ag_Class;
	}

	public String getAg_Opclss() {
		return ag_Opclss;
	}

	public void setAg_Opclss(String ag_Opclss) {
		this.ag_Opclss = ag_Opclss;
	}

	public String getAg_Msgfile() {
		return ag_Msgfile;
	}

	public void setAg_Msgfile(String ag_Msgfile) {
		this.ag_Msgfile = ag_Msgfile;
	}

	public String getSo_Hostname() {
		return so_Hostname;
	}

	public void setSo_Hostname(String so_Hostname) {
		this.so_Hostname = so_Hostname;
	}

	public String getSo_Port() {
		return so_Port;
	}

	public void setSo_Port(String so_Port) {
		this.so_Port = so_Port;
	}

	public String getSo_ClientTimeOut() {
		return so_ClientTimeOut;
	}

	public void setSo_ClientTimeOut(String so_ClientTimeOut) {
		this.so_ClientTimeOut = so_ClientTimeOut;
	}
	
	
}
