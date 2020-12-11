package com.itheima.config;

import com.itheima.app.MyService1;
import com.itheima.app.MyService2;
import com.itheima.app.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileNotFoundException;

public class TestSpring {

    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        MyService2 service = context.getBean(MyService2.class);

        service.m2();
    }

}
