package com.metalsa.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MetalsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetalsaApplication.class, args);
	}
}
