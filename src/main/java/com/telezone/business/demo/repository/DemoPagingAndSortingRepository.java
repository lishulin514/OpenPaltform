package com.telezone.business.demo.repository;

import com.telezone.business.demo.pojo.IPUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/5 13:21
 */
public interface DemoPagingAndSortingRepository extends PagingAndSortingRepository<IPUser, Integer> {
}
