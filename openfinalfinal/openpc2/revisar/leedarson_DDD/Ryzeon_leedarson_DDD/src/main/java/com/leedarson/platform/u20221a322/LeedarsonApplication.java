package com.leedarson.platform.u20221a322;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LeedarsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeedarsonApplication.class, args);
    }

}
