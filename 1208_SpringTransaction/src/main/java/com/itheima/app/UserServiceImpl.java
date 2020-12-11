package com.itheima.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

// 演示回滚问题
@Service
public class UserServiceImpl implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    // 开启事务
    public void m1() throws FileNotFoundException {
        System.out.println("m1");
//        int i = 1/0;
//        new FileInputStream("aaaa.txt");
//        throw new Error("aaa");
        throw new Error("aaa");
    }
    // 没有异常，提交事务
    // 有异常，回滚事务
}
