package com.inzent.ecm.confControl.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ServerDto {
	
	@Setter
	private String se_keepperfstats;
	
	private String se_basemsg;
	
	private String lo_Class;
	
	private String lo_Level;
	
	private String po_Name;
	
	private String po_Section;

	
	
	public String getSe_keepperfstats() {
		return se_keepperfstats;
	}

	public void setSe_keepperfstats(String se_keepperfstats) {
		this.se_keepperfstats = se_keepperfstats;
	}

	public String getSe_basemsg() {
		return se_basemsg;
	}

	public void setSe_basemsg(String se_basemsg) {
		this.se_basemsg = se_basemsg;
	}

	public String getLo_Class() {
		return lo_Class;
	}

	public void setLo_Class(String lo_Class) {
		this.lo_Class = lo_Class;
	}

	public String getLo_Level() {
		return lo_Level;
	}

	public void setLo_Level(String lo_Level) {
		this.lo_Level = lo_Level;
	}

	public String getPo_Name() {
		return po_Name;
	}

	public void setPo_Name(String po_Name) {
		this.po_Name = po_Name;
	}

	public String getPo_Section() {
		return po_Section;
	}

	public void setPo_Section(String po_Section) {
		this.po_Section = po_Section;
	}
	

}
