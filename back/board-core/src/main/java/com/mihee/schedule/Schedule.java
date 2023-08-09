package com.mihee.schedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    @Scheduled(cron = "10 * * * * *")
    public void schedule() {
        System.out.println(System.currentTimeMillis() + "------");
    }

    @Scheduled(fixedRate = 5000)
    public void schedule2() {
        System.out.println("fixed rate 5000------");
    }
}
