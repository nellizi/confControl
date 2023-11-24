package com.inzent.ecm.confControl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.MainService;

@Configuration
public class SpringConfig {

	
	@Bean
	public MainService mainService() {
		return new MainService();
	}

}
