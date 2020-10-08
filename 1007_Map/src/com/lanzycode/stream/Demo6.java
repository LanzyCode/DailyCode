package com.lanzycode.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*创建一个arraylist集合 使用随机数 存储10个60-100的数据 要求去重后，去掉最高分和最低分，将80分以上数据遍历打印*/
public class Demo6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 10; i++) {
            list.add(random.nextInt(100 - 60 + 1) + 60);
        }
        Collections.sort(list);
        System.out.println("生成的数据是" + list);
        list.stream().distinct().sorted().limit(9).skip(1).filter(integer -> integer >= 80).forEach(s -> System.out.println(s));
    }
}
