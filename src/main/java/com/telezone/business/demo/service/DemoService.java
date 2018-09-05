package com.telezone.business.demo.service;

import com.telezone.business.demo.pojo.IPUser;
import com.telezone.business.demo.repository.DemoCrudRepository;
import com.telezone.business.demo.repository.DemoPagingAndSortingRepository;
import com.telezone.business.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/5 11:42
 */
@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;
    @Autowired
    private DemoPagingAndSortingRepository demoPagingAndSortingRepository;
    @Autowired
    private DemoCrudRepository demoCrudRepository;


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
        Integer count = demoRepository.getCount();
        System.out.println(count);
        return null;
    }

    public List<IPUser> findByUsernameStartingWithAndTelephone(String Username, String telezone) {
//        List<IPUser> users = userRepository.getUsers();
//        System.out.println(users);
        return demoRepository.findByUsernameStartingWithAndTelephone(Username, telezone);
    }

    @Transactional
    public void updateUser(String id, String principalName){
        demoRepository.update(id, principalName);
    }

    @Transactional
    public void save(List<IPUser> users){
        demoCrudRepository.save(users);
    }

    public void testPage(){
        Pageable pageable = new PageRequest(0,5);
        Page<IPUser> all = demoPagingAndSortingRepository.findAll(pageable);
    }
}
