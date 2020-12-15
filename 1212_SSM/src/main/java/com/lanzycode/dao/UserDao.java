package com.lanzycode.dao;

import com.lanzycode.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //boolean类型 大于0为真 等于0为假

    public boolean save(User user);
    public boolean update(User user);
    public boolean delete(Integer uuid);
    public User get(Integer uuid);
    public List<User> getAll();
    public User getByUsernameAndPassword(@Param("userName") String username, @Param("passWord") String password);

}
