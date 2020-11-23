package com.itheima.service;

import com.itheima.bean.User;

public interface UserService {

    /**
     * 登陆功能
     */
    User login(String username,String password);
}
