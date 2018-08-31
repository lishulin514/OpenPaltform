package com.telezone.user.service;


import com.telezone.constant.PageParam;
import com.telezone.pojo.IPUser;

import java.util.List;

public interface IPUserService {

    public IPUser getUserByUsername(String usernmae);

    public List<IPUser> findByUsernameStartingWithAndTelephone(String Username, String telezone);

}
