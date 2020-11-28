package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("SELECT * FROM user")
    List<User> findAllUserInfo();

    @Insert("INSERT INTO user (id,username,email) VALUES (null,#{username},#{email})")
    void saveUserInfo(User user);

    @Update("UPDATE user SET username = #{username},email = #{email} WHERE id = #{id}")
    void updateUserInfo(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUserById(@Param("id") Integer id);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUserInfo(@Param("id") Integer id);
}
