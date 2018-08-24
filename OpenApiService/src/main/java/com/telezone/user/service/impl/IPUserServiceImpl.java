package com.telezone.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.telezone.constant.PageParam;
import com.telezone.pojo.IPUser;
import com.telezone.user.dao.IPUserMapper;
import com.telezone.user.dao.IPUserMapperCustom;
import com.telezone.user.service.IPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


@Service
public class IPUserServiceImpl implements IPUserService {
    @Autowired
    private IPUserMapper userDao;

    @Autowired
    private IPUserMapperCustom userDaoCustom;



    @Override
    public IPUser getUserById(String username) {
        return userDaoCustom.getUserByName(username);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<IPUser> getUserList(PageParam param, IPUser user) {
        PageHelper.startPage(param.getPage(),param.getRows());
        Example example = new Example(IPUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmptyOrWhitespace(user.getPrincipalName())){
            criteria.andLike("nickname", "%" + user.getPrincipalName() + "%");
        }
        example.orderBy("createTime").desc();
        return userDao.selectByExample(example);
    }

    @Override
    public void createUser(IPUser user){

        userDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransactional(IPUser user){
        int insert = userDao.insert(user);
        user.setModifyTime(new Date());
        userDao.updateByPrimaryKey(user);
    }
}
