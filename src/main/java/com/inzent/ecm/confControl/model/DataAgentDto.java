package com.inzent.ecm.confControl.model;

import java.util.List;

import org.apache.tomcat.util.buf.StringCache;

public class DataAgentDto {
	
	private String ag_Name;
	
	private String ag_Type;
	
	private String ag_Class;
	
	private String ag_Msgfile;
	
	private String po_Name;
	
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
	
	private String li_Lisrdir;
	
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

}
