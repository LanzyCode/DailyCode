package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.mapper.UserDao;
import com.itheima.service.UserService;
import com.itheima.utils.MybtisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
        //1，通过工具类获取SqlSession对象
        SqlSession sqlSession = MybtisUtils.getSqlSession();
        //2,获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //3,调用userDao对象中的findAll方法查询所有的用户数据
        List<User> users = userDao.findAll();

        //4,释放资源
        sqlSession.close();
        return users;
    }

    @Override
    public void deleteById(Integer id) {
        //1，通过工具类获取SqlSession对象
        SqlSession sqlSession = MybtisUtils.getSqlSession();
        //2,获取代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //3,调用代理对象的删除的方法
        userDao.deleteById(id);

        //4,释放资源
        sqlSession.close();
    }
}
