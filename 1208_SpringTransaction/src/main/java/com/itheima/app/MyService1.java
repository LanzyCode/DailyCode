package com.itheima.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MyService1 {

    @Transactional
    public void m1() {
        log.debug("m1");
        m2();
        int i = 1/0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m2() {
        log.debug("m2");
    }
}
