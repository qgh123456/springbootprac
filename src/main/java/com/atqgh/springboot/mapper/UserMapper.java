package com.atqgh.springboot.mapper;

import com.atqgh.springboot.bean.User;

/**
 * @Author: qiguohui
 * @Description:
 * @Date: Created in 9:33 2019/7/3
 * @Modified By:
 **/
public interface UserMapper {
    //增加用户
    void addUser(User user);
    //删除用户
    void deleteUser(Integer id);
    //根据id查询用户
    User getUserById(Integer id);
    //更新用户
    void updateUser(User user);

    Integer selectOne(String name);
}
