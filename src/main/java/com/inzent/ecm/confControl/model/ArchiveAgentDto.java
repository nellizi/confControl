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
	
	private String Aag_Name;
	
	private String Aag_Type;
	
	private String Aag_Desc;
	
	private String Aag_class;
	
	private String Aag_Opclass;
	
	private String Aag_Msgfile;
	
	private String sc_class;
	
	private String de_class;
	
	private String de_Basedir;
	
	private String de_Hashdirs;
	
	private String de_Dateformat;
	
	private String de_filesystemclass;
	
	private String de_filesystemkb;
	
	private String th_Ops;
	
	private String th_Count;

	

	public String getAag_Name() {
		return Aag_Name;
	}

	public void setAag_Name(String aag_Name) {
		Aag_Name = aag_Name;
	}

	public String getAag_Type() {
		return Aag_Type;
	}

	public void setAag_Type(String aag_Type) {
		Aag_Type = aag_Type;
	}

	public String getAag_Desc() {
		return Aag_Desc;
	}

	public void setAag_Desc(String aag_Desc) {
		Aag_Desc = aag_Desc;
	}

	public String getAag_class() {
		return Aag_class;
	}

	public void setAag_class(String aag_class) {
		Aag_class = aag_class;
	}

	public String getAag_Opclass() {
		return Aag_Opclass;
	}

	public void setAag_Opclass(String aag_Opclass) {
		Aag_Opclass = aag_Opclass;
	}

	public String getAag_Msgfile() {
		return Aag_Msgfile;
	}

	public void setAag_Msgfile(String aag_Msgfile) {
		Aag_Msgfile = aag_Msgfile;
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
