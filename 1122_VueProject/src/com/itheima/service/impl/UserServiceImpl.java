package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import com.itheima.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    /**
     * 登陆功能
     * @param username  ： 用户名
     * @param password  ： 密码
     * @return
     */
    @Override
    public User login(String username, String password) {
        //通过mybatis的工具类获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        //2,获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3,调用方法进行数据库操作
        User user = userMapper.findUserByUsernameAndPassword(username, password);

        //4,释放资源
        sqlSession.close();
        return user;
    }
}
