package com.db.graduates.restforclients;

import com.db.graduates.restforclients.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestForClientsApplication {

	@Autowired
	ChartService chartService;

	public static void main(String[] args) {
		SpringApplication.run(RestForClientsApplication.class, args);
	}
}
