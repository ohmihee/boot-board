package com.mihee.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.mihee.init"})
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.mihee.init"})
public class InitApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class, args);
        System.out.println("start server ------");

    }
}
