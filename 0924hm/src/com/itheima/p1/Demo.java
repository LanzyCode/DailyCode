package com.itheima.p1;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 22);
        Student student2 = new Student("张三", 22);
        Student student3 = new Student("李四", 22);
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student1.equals(student2));
        System.out.println(student2.equals(student3));

        BigDecimal bd1 = new BigDecimal("10.0");
        BigDecimal bd2 = new BigDecimal("3.0");
        System.out.println(bd1.add(bd2));
        System.out.println(bd1.subtract(bd2));
        System.out.println(bd1.multiply(bd2));
        System.out.println(bd1.divide(bd2, 2, BigDecimal.ROUND_UP));

        Integer integer = new Integer(Integer.MAX_VALUE);
        System.out.println(integer);
    }


}
