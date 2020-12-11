package com.itheima.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MyService3 {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void m3() {
        log.debug("m3");
    }
}
