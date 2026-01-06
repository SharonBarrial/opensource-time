package com.smarthome.platform.practica1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Practica1Application {

    public static void main(String[] args) {
        SpringApplication.run(Practica1Application.class, args);
    }

}
