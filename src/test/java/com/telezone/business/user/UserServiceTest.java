package com.telezone.business.user;

import com.telezone.OpenApiApplication;
import com.telezone.business.user.pojo.IPUser;
import com.telezone.business.user.service.IPUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/8/24 14:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Autowired
    private IPUserService userService;

//    @Autowired
//    private UserService userService;

    @Test
    public void getUsers() {
        IPUser userById = userService.getUserByUsername("lch");
        System.out.println(userById);
    }
    @Test
    public void testUpdate() {
       userService.updateUser("40a4f921-7de8-4116-b10f-a693e0c46fd5","lishulin");
    }
}
