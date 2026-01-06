package com.leedarson.platform.u202120430;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Pc2FiorellaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pc2FiorellaApplication.class, args);
    }

}
