package com.telezone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author： 李树林
 * @description： 服务器的启动类
 * @date： 2018/8/24 13:37
 */
@SpringBootApplication
//@MapperScan("com.telezone.user.dao")
//开启定时任务
//@EnableScheduling
//开启异步调用方法
//发送短信 发送邮件 App消息推送 节省运维凌晨发布任务时间提供效率
//@EnableAsync
public class OpenApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenApiApplication.class, args);
    }
}
