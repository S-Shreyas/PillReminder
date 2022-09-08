package com.ssn59.pillreminder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableJpaRepositories
//@EnableAutoConfiguration
//@Configuration
public class PillreminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PillreminderApplication.class, args);
	}

}