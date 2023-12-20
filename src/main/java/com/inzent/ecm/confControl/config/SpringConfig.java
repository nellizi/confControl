package com.inzent.ecm.confControl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inzent.ecm.confControl.service.ArchiveService;
import com.inzent.ecm.confControl.service.CommService;
import com.inzent.ecm.confControl.service.DataService;
import com.inzent.ecm.confControl.service.LocalAgentService;
import com.inzent.ecm.confControl.service.ServerService;

@Configuration
public class SpringConfig {

	
	@Bean
	public ArchiveService archiveService() {
		return new ArchiveService();
	}
	
	@Bean
	public CommService commService() {
		return new CommService();
	}
	
	@Bean
	public DataService dataService() {
		return new DataService();
	}
	
	@Bean
	public ServerService serverService() {
		return new ServerService();
	}
	
	@Bean
	public LocalAgentService localService() {
		return new LocalAgentService();
	}
	


}
