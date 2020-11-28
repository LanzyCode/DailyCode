package com.lanzycode.service;

import com.github.pagehelper.PageInfo;
import com.lanzycode.domain.User;

public interface UserService {

    PageInfo findByPage(int currentPage);

    void add(User user);

    void update(User user);

    void delete(String userId);

    User login(String username, String password);
}
