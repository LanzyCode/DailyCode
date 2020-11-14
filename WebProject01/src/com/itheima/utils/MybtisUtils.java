package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybtisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //私有构造方法
    private MybtisUtils() {}

    static {
        try {
            InputStream is = Resources.getResourceAsStream("MybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取sqlSession对象
    public static SqlSession getSqlSession() {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
