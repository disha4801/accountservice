package com.dnb.accountservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
//@EnableDiscoveryClient
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class AccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
	}
	
	@Bean
//	@Scope("prototype")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
