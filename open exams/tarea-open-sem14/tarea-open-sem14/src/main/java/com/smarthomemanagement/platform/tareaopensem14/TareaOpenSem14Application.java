package com.smarthomemanagement.platform.tareaopensem14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TareaOpenSem14Application {
	public static void main(String[] args) {
		SpringApplication.run(TareaOpenSem14Application.class, args);
	}

}
