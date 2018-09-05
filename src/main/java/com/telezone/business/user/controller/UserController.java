package com.telezone.business.user.controller;

import com.telezone.business.user.pojo.IPUser;
import com.telezone.business.user.service.IPUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        ipUserService.updateUser("40a4f921-7de8-4116-b10f-a693e0c46fd5","lishulin");
//        List<IPUser> admin = ipUserService.findByUsernameStartingWithAndTelephone("admin", "11");
//        System.out.println(JSON.toJSONString(admin));
        return null;
    }
}
