package com.lanzycode.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三,23");
        list.add("李四,24");
        list.add("王五,25");
        Map mp = list.stream().filter(s -> {
            String[] split = s.split(",");
            int age = Integer.parseInt(split[1]);
            return age >= 24;
        }).collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])
        ));
        System.out.println(mp);

    }
}
