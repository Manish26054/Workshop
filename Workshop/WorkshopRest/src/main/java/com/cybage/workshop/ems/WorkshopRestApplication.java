package com.cybage.workshop.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.cybage.workshop.dao")
@SpringBootApplication(scanBasePackages = "com.cybage.workshop")
@EntityScan(basePackages = "com.cybage.workshop.entity")
public class WorkshopRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopRestApplication.class, args);
	}

}
