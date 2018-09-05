package com.telezone.business.demo.repository;

import com.telezone.business.demo.pojo.IPUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/5 13:20
 */
public interface DemoCrudRepository extends CrudRepository<IPUser, Integer> {

}
