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

	public String getAg_Desc() {
		return ag_Desc;
	}

	public void setAg_Desc(String ag_Desc) {
		this.ag_Desc = ag_Desc;
	}

	public String getAg_class() {
		return ag_class;
	}

	public void setAg_class(String ag_class) {
		this.ag_class = ag_class;
	}

	public String getAg_Opclass() {
		return ag_Opclass;
	}

	public void setAg_Opclass(String ag_Opclass) {
		this.ag_Opclass = ag_Opclass;
	}

	public String getAg_Msgfile() {
		return ag_Msgfile;
	}

	public void setAg_Msgfile(String ag_Msgfile) {
		this.ag_Msgfile = ag_Msgfile;
	}

	public String getSc_class() {
		return sc_class;
	}

	public void setSc_class(String sc_class) {
		this.sc_class = sc_class;
	}

	public String getDe_class() {
		return de_class;
	}

	public void setDe_class(String de_class) {
		this.de_class = de_class;
	}

	public String getDe_Basedir() {
		return de_Basedir;
	}

	public void setDe_Basedir(String de_Basedir) {
		this.de_Basedir = de_Basedir;
	}

	public String getDe_Hashdirs() {
		return de_Hashdirs;
	}

	public void setDe_Hashdirs(String de_Hashdirs) {
		this.de_Hashdirs = de_Hashdirs;
	}

	public String getDe_Dateformat() {
		return de_Dateformat;
	}

	public void setDe_Dateformat(String de_Dateformat) {
		this.de_Dateformat = de_Dateformat;
	}

	public String getDe_filesystemclass() {
		return de_filesystemclass;
	}

	public void setDe_filesystemclass(String de_filesystemclass) {
		this.de_filesystemclass = de_filesystemclass;
	}

	public String getDe_filesystemkb() {
		return de_filesystemkb;
	}

	public void setDe_filesystemkb(String de_filesystemkb) {
		this.de_filesystemkb = de_filesystemkb;
	}

	public String getTh_Ops() {
		return th_Ops;
	}

	public void setTh_Ops(String th_Ops) {
		this.th_Ops = th_Ops;
	}

	public String getTh_Count() {
		return th_Count;
	}

	public void setTh_Count(String th_Count) {
		this.th_Count = th_Count;
	}
	
	
	
	

}
