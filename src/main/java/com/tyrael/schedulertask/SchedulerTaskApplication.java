package com.tyrael.schedulertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableRetry
@SpringBootApplication
public class SchedulerTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerTaskApplication.class, args);
    }

}
