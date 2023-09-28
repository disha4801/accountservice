package com.dnb.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
//@EnableDiscoveryClient
//@EnableFeignClients
@SpringBootApplication
public class AccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
//	@Scope("prototype")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
