package com.telezone.user.controller;

import com.telezone.user.service.IPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/8/24 17:52
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IPUserService ipUserService;

    @RequestMapping("/test/websocket")
    public String webSocketSend(HttpServletRequest request){

        return null;
    }
}
