package com.telezone.business.user.service;


import com.telezone.business.user.pojo.IPUser;
import com.telezone.business.user.repository.UserCrudRepository;
import com.telezone.business.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class IPUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Transactional(propagation = Propagation.SUPPORTS)
    public IPUser getUserByUsername(String username) {
//        List<IPUser> ipUsers1 = userRepository.queryParams1("lch","202CB962AC59075B964B07152D234B70");
//        List<IPUser> ipUsers2 = userRepository.queryParams2("admin1","202CB962AC59075B964B07152D234B70");
//        System.out.println(JSON.toJSONString(ipUsers1));
//        System.out.println(JSON.toJSONString(ipUsers2));
//        List<IPUser> ipUsers = userRepository.queryLike1("lc");
//        List<IPUser> admin = userRepository.findLike1("admin");
//        System.out.println(JSON.toJSONString(ipUsers));
//        System.out.println(JSON.toJSONString(admin));
        Integer count = userRepository.getCount();
        System.out.println(count);
        return null;
    }

    public List<IPUser> findByUsernameStartingWithAndTelephone(String Username, String telezone) {
//        List<IPUser> users = userRepository.getUsers();
//        System.out.println(users);
        return userRepository.findByUsernameStartingWithAndTelephone(Username, telezone);
    }

    @Transactional
    public void updateUser(String id, String principalName){
        userRepository.update(id, principalName);
    }

    @Transactional
    public void save(List<IPUser> users){
        userCrudRepository.save(users);
    }
}
