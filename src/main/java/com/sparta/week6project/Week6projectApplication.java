package com.sparta.week6project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class Week6projectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week6projectApplication.class, args);
    }

    @PostConstruct
    public void started(){ TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")); }

}
