package com.itheima.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<String> c = new ArrayList<>();
        c.add("张三");
        c.add("李四");
        c.add("王五");
        c.add("周六");
        c.add("田七");
        System.out.println(c);
        Collections.reverse(c);
        System.out.println(c);
        Collections.shuffle(c);
        System.out.println(c);
    }
}
