package com.lanzycode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        Student stu=new Student();
        StudentInterface si = (StudentInterface) Proxy.newProxyInstance(stu.getClass().getClassLoader(), new Class[]{StudentInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("study")) {
                    method.invoke(stu, args);
                    System.out.println("来机构学习");
                    return null;
                } else {
                    return method.invoke(stu, args);
                }
            }
        });
        si.eat("米饭");
        si.study();
    }
}
