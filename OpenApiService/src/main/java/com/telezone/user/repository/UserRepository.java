package com.telezone.user.repository;

import com.telezone.pojo.IPUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/8/31 15:18
 */
@Repository
public interface UserRepository extends JpaRepository<IPUser, String>{

    IPUser findByUsername(String username);
}
