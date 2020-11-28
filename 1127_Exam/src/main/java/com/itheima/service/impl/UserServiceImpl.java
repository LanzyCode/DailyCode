package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.factory.MapperFactory;
import com.itheima.service.UserService;
import com.itheima.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * User的接口实现类.
 */


public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public List<User> findAllUserInfo() {
        //1.获取SqlSession对象.
        try (SqlSession sqlSession = MapperFactory.getSqlSession(true)) {
            //2.获取dao对象
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.使用dao对象的方法进行操作并且返回数据
            return userDao.findAllUserInfo();
        }
    }

    @Override
    public void saveUserInfo(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession对象.
            sqlSession = MapperFactory.getSqlSession(true);
            //2.获取dao对象
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.使用dao对象的方法进行操作.
            userDao.saveUserInfo(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            //5.如果出现了异常,回滚事务并且抛出异常方便表现层进行拦截.
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User selectUserById(Integer id) {
        //1.获取SqlSession对象.
        try (SqlSession sqlSession = MapperFactory.getSqlSession(true)) {
            //2.获取dao对象
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.使用dao对象的方法进行操作并且返回数据
            return userDao.selectUserById(id);
        }
    }

    @Override
    public void updateUserInfo(User user) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession对象.
            sqlSession = MapperFactory.getSqlSession(true);
            //2.获取dao对象
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.使用dao对象的方法进行操作.
            userDao.updateUserInfo(user);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            //5.如果出现了异常,回滚事务并且抛出异常方便表现层进行拦截.
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUserInfo(Integer id) {
        SqlSession sqlSession = null;
        try {
            //1.获取SqlSession对象.
            sqlSession = MapperFactory.getSqlSession(true);
            //2.获取dao对象
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            //3.使用dao对象的方法进行操作.
            userDao.deleteUserInfo(id);
            //4.提交事务
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            //5.如果出现了异常,回滚事务并且抛出异常方便表现层进行拦截.
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
