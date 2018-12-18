package com.istest.dao;

import com.istest.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserDao {

    /**
     * 保存用户
     * @param user
     */
    @Insert("INSERT INTO USER(NAME,money) VALUES(#{name},#{money})")
    public void saveUser(User user);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    @Select("Select * from user where name = #{name}")
    public User findByName(String name);

    /**
     * 更新用户数据
     * @param user
     */
    @Update("Update user set name = #{name},money = #{money} where id = #{id}")
    public void update(User user);

}
