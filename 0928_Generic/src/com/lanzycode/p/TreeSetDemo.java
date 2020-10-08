package com.lanzycode.p;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("张三", 20, 88.50));
        treeSet.add(new Student("李四", 19, 100.50));
        treeSet.add(new Student("王五", 22, 100.50));
        treeSet.add(new Student("赵六", 29, 78.50));
        treeSet.add(new Student("田七", 27, 68.50));
        System.out.println(treeSet);
    }
}
