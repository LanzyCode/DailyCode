package com.lanzycode.proxy;

public class Student implements StudentInterface {
    @Override
    public void eat(String name) {
        System.out.println("学生吃"+name);
    }

    @Override
    public void study() {
        System.out.println("在家自学");
    }
}
