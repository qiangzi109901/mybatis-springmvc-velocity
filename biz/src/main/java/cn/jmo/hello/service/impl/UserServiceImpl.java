package cn.jmo.hello.service.impl;

import cn.jmo.hello.dao.UserDao;
import cn.jmo.hello.model.UserDO;
import cn.jmo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserDO> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {

        UserDO userDO = new UserDO();
        userDO.setAge(20);
        userDO.setGender("男");
        userDO.setUsername("张三");
        userDao.insert(userDO);

        int m = 10 / 0;

        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

    }
}