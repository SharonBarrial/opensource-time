package com.kaeser.platform.ebpractice_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EbPractice2Application {
    public static void main(String[] args) {
        SpringApplication.run(EbPractice2Application.class, args);
    }

}