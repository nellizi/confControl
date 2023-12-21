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

	private String Cag_Name;
	
	private String Cag_Type;
	
	private String Cag_Class;
	
	private String Cag_Opclss;
	
	private String Cag_Msgfile;
	
	private String so_Hostname;
	
	private String so_Port;
	
	private String so_ClientTimeOut;

	

	public String getCag_Name() {
		return Cag_Name;
	}

	public void setCag_Name(String cag_Name) {
		Cag_Name = cag_Name;
	}

	public String getCag_Type() {
		return Cag_Type;
	}

	public void setCag_Type(String cag_Type) {
		Cag_Type = cag_Type;
	}

	public String getCag_Class() {
		return Cag_Class;
	}

	public void setCag_Class(String cag_Class) {
		Cag_Class = cag_Class;
	}

	public String getCag_Opclss() {
		return Cag_Opclss;
	}

	public void setCag_Opclss(String cag_Opclss) {
		Cag_Opclss = cag_Opclss;
	}

	public String getCag_Msgfile() {
		return Cag_Msgfile;
	}

	public void setCag_Msgfile(String cag_Msgfile) {
		Cag_Msgfile = cag_Msgfile;
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
