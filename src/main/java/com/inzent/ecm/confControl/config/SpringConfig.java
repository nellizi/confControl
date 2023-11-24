package com.inzent.ecm.confControl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.ArchiveService;
import service.CommService;
import service.DataService;
import service.ServerService;

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

}
