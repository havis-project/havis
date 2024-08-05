package com.havis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HavisApplication {

    public static void main(String[] args) {
        SpringApplication.run(HavisApplication.class, args);
    }

}
