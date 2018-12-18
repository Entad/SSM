package com.istest.service;

import com.istest.domain.User;

public interface UserService {


    /**
     * 保存用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    public User findByName(String name);

    /**
     * 更新用户数据
     * @param user
     */
    public void update(User user);


    /**
     * 转账
     * @param sourName
     * @param targetName
     * @param money
     */
    public void transfer(String sourName, String targetName, Double money);
}
