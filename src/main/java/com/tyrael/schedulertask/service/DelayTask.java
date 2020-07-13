package com.tyrael.schedulertask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DelayTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 10000)
    public void delayTaskCurrentTime() {
        System.out.println("延迟任务，执行时间：" + dateFormat.format(new Date()));
    }
}
