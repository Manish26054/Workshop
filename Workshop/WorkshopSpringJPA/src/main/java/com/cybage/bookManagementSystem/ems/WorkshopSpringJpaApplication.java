package com.cybage.bookManagementSystem.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.cybage.bookManagementSystem.dao")
@SpringBootApplication(scanBasePackages = "com.cybage.bookManagementSystem")
@EntityScan(basePackages = "com.cybage.bookManagementSystem.model")
public class WorkshopSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpringJpaApplication.class, args);
	}

}
