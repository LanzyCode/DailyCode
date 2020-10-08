package com.lanzycode.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo7 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        System.out.println(list1);
        Set<Integer> set = list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);
    }
}
