package com.lanzycode.h2;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Student stu1 = new Student("张三", "男", 20, 79.5);
        Student stu2 = new Student("李四", "女", 21, 80.2);
        Student stu3 = new Student("王五", "男", 22, 77.9);
        Student stu4 = new Student("周六", "男", 20, 55.8);
        Student stu5 = new Student("赵七", "女", 21, 99.9);

        double sum = stu1.getScore() + stu2.getScore() + stu3.getScore() + stu4.getScore() + stu5.getScore();
        double avg = sum / 5;
        BigDecimal bd = new BigDecimal(avg);
        System.out.println(bd.divide(BigDecimal.valueOf(1), 2, BigDecimal.ROUND_HALF_UP));
    }
}
