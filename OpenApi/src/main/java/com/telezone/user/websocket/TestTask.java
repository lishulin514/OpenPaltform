package com.telezone.user.websocket;

import com.telezone.config.NettyConfig;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TestTask {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate = 3000  单位毫秒
     * 最多6位不支持年
     */
    @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime(){
        NettyConfig.group.writeAndFlush(new TextWebSocketFrame("111"));
    }
}