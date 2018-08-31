package com.telezone.user.service.impl;

import com.telezone.pojo.IPUser;
import com.telezone.user.repository.UserRepository;
import com.telezone.user.service.IPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class IPUserServiceImpl implements IPUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public IPUser getUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public List<IPUser> findByUsernameStartingWithAndTelephone(String Username, String telezone) {

        return userRepository.findByUsernameStartingWithAndTelephone(Username, telezone);
    }
}