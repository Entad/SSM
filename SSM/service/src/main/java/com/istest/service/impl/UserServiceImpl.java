package com.istest.service.impl;

import com.istest.dao.UserDao;
import com.istest.domain.User;
import com.istest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 保存用户
     * @param user
     */
    @Override
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Override
    public User findByName(String name) {

        return userDao.findByName(name);
    }

    /**
     * 更新用户数据
     * @param user
     */
    @Override
    public void update(User user) {

        userDao.update(user);
    }

    /**
     * 转账
     * @param sourName
     * @param targetName
     * @param money
     */
    @Override
    public void transfer(String sourName, String targetName, Double money) {
        //根据用户名查询
        User sour = userDao.findByName(sourName);
        User target = userDao.findByName(targetName);

        sour.setMoney(sour.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        if(sour.getMoney() >= money){

            userDao.update(sour);
            //int a = 1/0;
            userDao.update(target);
        }else {
            throw new RuntimeException("钱不够!");
        }


    }


}
