package com.library.platform.upc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class Ejercicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}

}
