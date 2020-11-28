package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.UserMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    public PageInfo findByPage(int currentPage) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        PageHelper.startPage(currentPage,5);
        //调用查询方法
        List<User> list = userMapper.findAll();

        PageInfo pageInfo = new PageInfo(list);

        sqlSession.close();
        return pageInfo;
    }

    public void add(User user) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        //调用添加方法
        userMapper.add(user);

        sqlSession.close();
    }

    public void update(User user) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用修改方法
        userMapper.update(user);

        sqlSession.close();
    }

    public void delete(String userId) {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用添加方法
        userMapper.delete(userId);

        sqlSession.close();
    }

    public User login(String username, String password) {

        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用添加方法
        User user = userMapper.findByUsernameAndPassword(username,password);

        sqlSession.close();

        return user;
    }
}
