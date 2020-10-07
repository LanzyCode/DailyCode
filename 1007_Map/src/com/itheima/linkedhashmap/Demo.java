package com.itheima.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("恭", "大");
        map.put("喜", "吉");
        map.put("吃", "大");
        map.put("鸡", "利");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key:" + key + " Value:" + value);
        }


//        Set<String> keySet = map.keySet();
//        for (String key : keySet) {
//            String value = map.get(key);
//            System.out.println("Key:" + value + " Value:" + key);
//        }

    }
}
