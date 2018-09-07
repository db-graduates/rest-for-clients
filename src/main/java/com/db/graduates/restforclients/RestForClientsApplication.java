package com.db.graduates.restforclients;

import com.db.graduates.restforclients.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RestForClientsApplication {

	@Autowired
	ChartService chartService;

	public static void main(String[] args) {
		SpringApplication.run(RestForClientsApplication.class, args);
	}
}
