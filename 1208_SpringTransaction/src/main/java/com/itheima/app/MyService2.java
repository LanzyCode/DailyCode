package com.itheima.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MyService2 {

    @Autowired
    private MyService3 myService3;

    @Transactional
    public void m2() {
        log.debug("m2");
        myService3.m3();
        int i = 1/0;
    }





}
