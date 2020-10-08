package com.lanzycode.p;

import java.util.*;

/*
 * Collection
 *   Set
 *       HashSet
 *           LinkedHashSet
 *       TreeSet
 *   List*/
public class SetDemo {
    public static void main(String[] args) {
        //1.通过多态创建集合
        Set<String> set = new HashSet<>();
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new LinkedHashSet<>();
        //2.由于Set接口继承自Collection接口，那么set集合也会继承Collection的抽象方法
        //特点：唯一的，HashSet无序的,无索引
        set2.add("张三");
        set2.add("李四");
        set2.add("王五");
        set2.add("王五");
        System.out.println(set2);
        System.out.println("-----------------");
        Iterator<String> iterator = set2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");
        for (String s : set2) {
            System.out.println(s);
        }
    }
}
