package com.lanzycode.reflect;

import com.lanzycode.domain.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Student student = (Student) Class.forName("com.lanzycode.domain.Student").getConstructor(String.class,int.class).newInstance("张三",23);
//        System.out.println(student);

        Class<?> cs = Class.forName("com.lanzycode.domain.Student");
        Constructor<?> c = cs.getDeclaredConstructor(String.class,int.class);
        c.setAccessible(true);
        Student s1 = (Student) c.newInstance("李四",23);
        System.out.println(s1);

    }
}
