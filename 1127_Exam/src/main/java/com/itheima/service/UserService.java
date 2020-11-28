package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * User的接口类.
 */


public interface UserService {

    /**
     * 1.查找所有用户信息
     * @return
     */
    public List<User> findAllUserInfo();

    /**
     * 2.新增用户信息
     * @param user
     */
    void saveUserInfo(User user);

    /**
     * 3.根据Id查找用户信息
     * @param id
     */
    User selectUserById(Integer id);

    /**
     * 4.修改用户信息
     * @param user
     */
    void updateUserInfo(User user);

    /**
     * 5.删除用户信息
     * @param id
     */
    void deleteUserInfo(Integer id);
}
