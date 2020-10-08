package com.lanzycode.hm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        List<String> list = List.of("张三疯,99", "王思聪,33", "张靓颖,35", "张飞,16");
        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(collect);
    }
}
