package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;

public interface UserService {

    PageInfo findByPage(int currentPage);

    void add(User user);

    void update(User user);

    void delete(String userId);

    User login(String username, String password);
}
