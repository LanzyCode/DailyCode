package com.itheima.bean;

public class Demo {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("海洋");


        Student stu1 = new Student();
        stu1.setName(stu.getName());

        stu1.setName("张鑫");

        System.out.println(stu.getName());
    }
}
