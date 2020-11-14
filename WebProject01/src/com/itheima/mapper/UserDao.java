package com.itheima.mapper;

import com.itheima.bean.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void deleteById(Integer id);
}
