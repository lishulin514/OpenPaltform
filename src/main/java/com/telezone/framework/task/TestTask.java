package com.telezone.framework.task;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

//@Component
public class TestTask {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate = 3000  单位毫秒
     * 最多6位不支持年
     */
    @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
    }
}
