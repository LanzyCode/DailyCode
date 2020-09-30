package com.itheima.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        String[] strings = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));
    }
}
