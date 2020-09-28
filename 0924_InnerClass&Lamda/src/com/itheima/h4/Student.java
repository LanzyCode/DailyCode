package com.itheima.h4;

public class Student {
    private String name;
    private int age;
    private double high;
    private boolean marry;
    private char gender;

    public Student() {
    }

    public Student(String name, int age, double high, boolean marry, char gender) {
        this.name = name;
        this.age = age;
        this.high = high;
        this.marry = marry;
        this.gender = gender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", high=").append(high);
        sb.append(", marry=").append(marry);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
