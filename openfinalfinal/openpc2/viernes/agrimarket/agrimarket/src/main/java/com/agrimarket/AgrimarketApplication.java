package com.agrimarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//Add EnableJpaAuditing annotation to enable JPA Auditing
@EnableJpaAuditing
public class AgrimarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgrimarketApplication.class, args);
	}

}
