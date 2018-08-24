package com.telezone.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/8/24 17:57
 */
@Controller
@RequestMapping("websocket")
public class WebSocketController {

    @RequestMapping("/test")
    public String webSocketSend(HttpServletRequest request){

        return null;
    }
}
