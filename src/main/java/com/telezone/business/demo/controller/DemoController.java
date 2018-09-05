package com.telezone.business.demo.controller;

import com.telezone.business.demo.service.DemoService;
import com.telezone.business.demo.pojo.IPUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/5 11:41
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public String webSocketSend(HttpServletRequest request){

        IPUser lch = demoService.getUserByUsername("lch");
        demoService.updateUser("40a4f921-7de8-4116-b10f-a693e0c46fd5","lishulin");
//        List<IPUser> admin = ipUserService.findByUsernameStartingWithAndTelephone("admin", "11");
//        System.out.println(JSON.toJSONString(admin));
        return null;
    }
}
