package com.lanzycode.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王老五");
        list.add("王五");
        list.add("赵六");

        ArrayList<String> aList = new ArrayList<>(list);

        for (String s : aList) {
            aList.add(s);
        }
        System.out.println(aList);
    }

}
