package com.itheima.service;

import com.itheima.bean.User;

import java.util.List;

public interface UserService {

    //查询所有的用户数据
    List<User> findAll();

    void deleteById(Integer parseInt);
}
