package com.lanzycode.stream;

import java.util.*;

public class Demo4 {
    public static void main(String[] args) {

    }

    private static void ArrMethod() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Arrays.stream(arr).forEach(s -> System.out.println(s));
    }

    private static void ListStream() {
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.stream().forEach(s -> System.out.println(s));
    }

    private static void MapMethod() {
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("张三", 20);
        mp.put("李四", 21);
        mp.put("王五", 22);
        mp.put("赵六", 23);
//      mp.keySet().stream().forEach(s -> System.out.println(s));
        Set<Map.Entry<String, Integer>> entries = mp.entrySet();
        entries.stream().forEach(s -> System.out.println(s));
    }
}
