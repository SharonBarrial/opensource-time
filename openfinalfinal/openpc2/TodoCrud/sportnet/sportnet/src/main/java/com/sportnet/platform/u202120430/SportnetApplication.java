package com.sportnet.platform.u202120430;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SportnetApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportnetApplication.class, args);
    }
}
