package com.itheima.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// 演示回滚问题
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    @Transactional
    public void m1() {
        try {
            log.debug("m1");
            int i = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
