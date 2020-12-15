package com.lanzycode.service.impl;

import com.lanzycode.dao.UserDao;
import com.lanzycode.domain.User;
import com.lanzycode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public boolean save(User user) {
        return userDao.save(user);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean delete(Integer uuid) {
        return userDao.delete(uuid);
    }

    public User get(Integer uuid) {
        return userDao.get(uuid);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User login(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }
}
