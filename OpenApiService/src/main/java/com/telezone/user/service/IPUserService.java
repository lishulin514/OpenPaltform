package com.telezone.user.service;


import com.telezone.constant.PageParam;
import com.telezone.pojo.IPUser;

import java.util.List;

public interface IPUserService {

    public IPUser getUserById(String id);

    List<IPUser> getUserList(PageParam param, IPUser user);

    void createUser(IPUser user);

    void testTransactional(IPUser user);
}
