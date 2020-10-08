package com.lanzycode.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("张三");
        c.add("李四");
        c.add("王五");
        c.add("周六");
        c.add("田七");
        System.out.println(c);
        /*c.clear();
        System.out.println(c);*/
        System.out.println(c.contains("张三"));
        System.out.println("集合为空吗？" + c.isEmpty());
        System.out.println("集合的长度为：" + c.size());
        System.out.println(c.remove("田七"));
        c.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("周六");
            }
        });
        System.out.println(c);
        
        /*Collection<Integer> intList=new ArrayList<>();
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(1);
        intList.add(2);
        System.out.println(intList);
        intList.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.equals(1);
            }
        });
        System.out.println(intList);*/
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
