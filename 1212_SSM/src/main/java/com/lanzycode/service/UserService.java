package com.lanzycode.service;

import com.lanzycode.dao.UserDao;
import com.lanzycode.domain.User;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
public interface UserService {

    public boolean save(User user);
    public boolean update(User user);
    public boolean delete(Integer uuid);
    public User get(Integer uuid);
    public List<User> getAll();
    public User login(String username,String password);
}
