package com.base.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasePlatformApplication.class, args);
    }

}
