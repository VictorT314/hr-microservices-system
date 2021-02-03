package com.system.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	//REST_TEMPLATE OBJECT FOR WORKER INSTANCES
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
