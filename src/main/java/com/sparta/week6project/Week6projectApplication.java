package com.sparta.week6project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week6projectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week6projectApplication.class, args);
    }

}
