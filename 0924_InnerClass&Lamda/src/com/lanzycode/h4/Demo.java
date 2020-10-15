package com.lanzycode.h4;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("王哈哈");
        student.setAge(Integer.valueOf("24"));
        student.setHigh(Double.valueOf("1.82"));
        student.setMarry(Boolean.valueOf("false"));
        student.setGender(Character.valueOf('男'));
        System.out.println(student);
        System.out.println(student.getName() + student.getAge() + student.getHigh() + student.getGender() + student.isMarry());
    }
}
