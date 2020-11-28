package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    void add(User user);

    void update(User user);

    void delete(String id);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
