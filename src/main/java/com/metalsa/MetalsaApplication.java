package com.metalsa;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class MetalsaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MetalsaApplication.class, args);
		SpringApplication app = new SpringApplication(MetalsaApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
	}
}
