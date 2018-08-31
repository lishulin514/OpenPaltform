package com.telezone.user.controller;

import com.alibaba.fastjson.JSON;
import com.telezone.pojo.IPUser;
import com.telezone.user.service.IPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/8/24 17:52
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IPUserService ipUserService;

    @RequestMapping("/test")
    public String webSocketSend(HttpServletRequest request){

        IPUser lch = ipUserService.getUserByUsername("lch");
        return JSON.toJSONString(lch);
    }
}
