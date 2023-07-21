package com.example.slackmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SlackMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlackMessageApplication.class, args);
    }

}
