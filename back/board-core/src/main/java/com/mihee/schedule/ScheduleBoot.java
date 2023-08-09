package com.mihee.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.mihee.schedule"})
@EnableScheduling
public class ScheduleBoot {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleBoot.class, args);
        System.out.println("start server ------");
    }
}
