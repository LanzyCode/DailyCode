package com.itheima.app;

import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Transactional // 只对关系型数据库有用 mysql, oracle, sql server
//                mongodb, redis ...
public interface OrderService {

    public void m1();
}
