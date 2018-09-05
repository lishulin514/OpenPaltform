package com.telezone.business.demo.repository;

import com.telezone.business.demo.pojo.IPUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author： 李树林
 * @description：
 * @date： 2018/9/5 11:44
 */
public interface DemoRepository extends JpaRepository<IPUser, String> {
    IPUser findByUsername(String username);

    /**
     * 根据命名规则查询
     * @param Username
     * @param telezone
     * @return
     */
    List<IPUser> findByUsernameStartingWithAndTelephone(String Username, String telezone);

    @Query("select u from IPUser u where u.username = ?1 and u.password = ?2")
    public List<IPUser> queryParams1(String username ,String password);

    @Query("select u from IPUser u where u.username =  :username and u.password = :password")
    public List<IPUser> queryParams2(@Param("username") String username , @Param("password") String password);

    @Query("select u from IPUser u where u.username like %?1%")
    public List<IPUser> queryLike1(String username);

    @Query("select u from IPUser u where u.username like %?1%")
    public List<IPUser> findLike1(String username);

    @Query(nativeQuery = true, value =
            "select count(u.id) from IP_USERS_T u")
    public Integer getCount();

    @Query(nativeQuery = true, value =
            "select count(u.id) from IP_USERS_T u")
    public Integer getJOIN();

    @Modifying
    @Query("update IPUser u set u.principalName = :principalName where u.id = :id")
    public void update(@Param("id") String id, @Param("principalName") String principalName);
}
