package com.telezone.business.user.repository;

import com.telezone.business.user.pojo.IPUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/4 18:36
 */
public interface UserCrudRepository extends CrudRepository<IPUser, Integer>{

}
