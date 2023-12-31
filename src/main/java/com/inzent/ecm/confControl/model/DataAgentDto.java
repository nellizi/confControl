package com.inzent.ecm.confControl.model;

import java.util.List;

import org.apache.tomcat.util.buf.StringCache;

public class DataAgentDto {
	
	private String Dag_Name;
	
	private String Dag_Type;
	
	private String Dag_Class;
	
	private String Dag_Msgfile;
	
	private String Dpo_Name;
	
	private String po_Driver;

	private String po_Connect;
	
	private String po_Dbtype;
	
	private String po_User;
	
	private String po_Pswd;
	
	private String po_Count;
	
	private String po_Preconnect;
	
	private String po_Unicode;
	
	private String st_MainpoolString;
	
	private String st_Locasysime;
	
	private String st_retentionignore;
	
	private String li_Listdir;
	
	private String li_Memcache;
	
	private String li_Timeout;
	
	private String ph_Iteration;
	
	private String ph_OnErrorReadOnly;
	
	private String ac_Iteration;
	
	private String ch_CheckQueryEnable;
	
	private String ch_SheckQueryTimeout;
	
	private String ch_Validationinterval;
	
	private String de_Agentserver;
	
	private String de_AgentName;
	
	private List<String> farm;              //임시***

	

	public String getDag_Name() {
		return Dag_Name;
	}

	public void setDag_Name(String dag_Name) {
		Dag_Name = dag_Name;
	}

	public String getDag_Type() {
		return Dag_Type;
	}

	public void setDag_Type(String dag_Type) {
		Dag_Type = dag_Type;
	}

	public String getDag_Class() {
		return Dag_Class;
	}

	public void setDag_Class(String dag_Class) {
		Dag_Class = dag_Class;
	}

	public String getDag_Msgfile() {
		return Dag_Msgfile;
	}

	public void setDag_Msgfile(String dag_Msgfile) {
		Dag_Msgfile = dag_Msgfile;
	}

	public void setLi_Listdir(String li_Listdir) {
		this.li_Listdir = li_Listdir;
	}

	public String getDPo_Name() {
		return Dpo_Name;
	}

	public void setDPo_Name(String po_Name) {
		this.Dpo_Name = po_Name;
	}

	public String getPo_Driver() {
		return po_Driver;
	}

	public void setPo_Driver(String po_Driver) {
		this.po_Driver = po_Driver;
	}

	public String getPo_Connect() {
		return po_Connect;
	}

	public void setPo_Connect(String po_Connect) {
		this.po_Connect = po_Connect;
	}

	public String getPo_Dbtype() {
		return po_Dbtype;
	}

	public void setPo_Dbtype(String po_Dbtype) {
		this.po_Dbtype = po_Dbtype;
	}

	public String getPo_User() {
		return po_User;
	}

	public void setPo_User(String po_User) {
		this.po_User = po_User;
	}

	public String getPo_Pswd() {
		return po_Pswd;
	}

	public void setPo_Pswd(String po_Pswd) {
		this.po_Pswd = po_Pswd;
	}

	public String getPo_Count() {
		return po_Count;
	}

	public void setPo_Count(String po_Count) {
		this.po_Count = po_Count;
	}

	public String getPo_Preconnect() {
		return po_Preconnect;
	}

	public void setPo_Preconnect(String po_Preconnect) {
		this.po_Preconnect = po_Preconnect;
	}

	public String getPo_Unicode() {
		return po_Unicode;
	}

	public void setPo_Unicode(String po_Unicode) {
		this.po_Unicode = po_Unicode;
	}

	public String getSt_MainpoolString() {
		return st_MainpoolString;
	}

	public void setSt_MainpoolString(String st_MainpoolString) {
		this.st_MainpoolString = st_MainpoolString;
	}

	public String getSt_Locasysime() {
		return st_Locasysime;
	}

	public void setSt_Locasysime(String st_Locasysime) {
		this.st_Locasysime = st_Locasysime;
	}

	public String getSt_retentionignore() {
		return st_retentionignore;
	}

	public void setSt_retentionignore(String st_retentionignore) {
		this.st_retentionignore = st_retentionignore;
	}

	public String getLi_Listdir() {
		return li_Listdir;
	}

	public void setLi_Lisrdir(String li_Lisrdir) {
		this.li_Listdir = li_Lisrdir;
	}

	public String getLi_Memcache() {
		return li_Memcache;
	}

	public void setLi_Memcache(String li_Memcache) {
		this.li_Memcache = li_Memcache;
	}

	public String getLi_Timeout() {
		return li_Timeout;
	}

	public void setLi_Timeout(String li_Timeout) {
		this.li_Timeout = li_Timeout;
	}

	public String getPh_Iteration() {
		return ph_Iteration;
	}

	public void setPh_Iteration(String ph_Iteration) {
		this.ph_Iteration = ph_Iteration;
	}

	public String getPh_OnErrorReadOnly() {
		return ph_OnErrorReadOnly;
	}

	public void setPh_OnErrorReadOnly(String ph_OnErrorReadOnly) {
		this.ph_OnErrorReadOnly = ph_OnErrorReadOnly;
	}

	public String getAc_Iteration() {
		return ac_Iteration;
	}

	public void setAc_Iteration(String ac_Iteration) {
		this.ac_Iteration = ac_Iteration;
	}

	public String getCh_CheckQueryEnable() {
		return ch_CheckQueryEnable;
	}

	public void setCh_CheckQueryEnable(String ch_CheckQueryEnable) {
		this.ch_CheckQueryEnable = ch_CheckQueryEnable;
	}

	public String getCh_SheckQueryTimeout() {
		return ch_SheckQueryTimeout;
	}

	public void setCh_SheckQueryTimeout(String ch_SheckQueryTimeout) {
		this.ch_SheckQueryTimeout = ch_SheckQueryTimeout;
	}

	public String getCh_Validationinterval() {
		return ch_Validationinterval;
	}

	public void setCh_Validationinterval(String ch_Validationinterval) {
		this.ch_Validationinterval = ch_Validationinterval;
	}

	public String getDe_Agentserver() {
		return de_Agentserver;
	}

	public void setDe_Agentserver(String de_Agentserver) {
		this.de_Agentserver = de_Agentserver;
	}

	public String getDe_AgentName() {
		return de_AgentName;
	}

	public void setDe_AgentName(String de_AgentName) {
		this.de_AgentName = de_AgentName;
	}

	public List<String> getFarm() {
		return farm;
	}

	public void setFarm(List<String> farm) {
		this.farm = farm;
	}

}
