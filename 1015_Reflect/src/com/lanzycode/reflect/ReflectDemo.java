package com.lanzycode.reflect;

import com.lanzycode.domain.Student;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cs = Class.forName("com.lanzycode.domain.Student");
        System.out.println(cs);

        Class<Student> cs2 = Student.class;
        System.out.println(cs2);

        Class cs3 = new Student().getClass();
        System.out.println(cs3);
    }
}
