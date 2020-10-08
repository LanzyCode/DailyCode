package com.lanzycode.stream;

import java.util.ArrayList;

public class Demo5 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        list.stream().filter(integer -> integer % 2 == 0).forEach(s -> System.out.println(s));
    }
}
