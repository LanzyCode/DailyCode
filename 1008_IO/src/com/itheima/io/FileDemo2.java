package com.itheima.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileDemo2 {
    private static final HashMap<String, Integer> COUNT_MAP = new HashMap<>();

    public static void main(String[] args) {
        File sreFolder = new File("/Users/shawn/Documents");
        File[] files = sreFolder.listFiles();
        for (File file : files) {
            String name = file.getName();
//          String suffix = name.split("\\.")[1];
            String suffix = name.substring(name.indexOf(".") + 1);
            if (COUNT_MAP.containsKey(suffix)) {
                COUNT_MAP.put(suffix, COUNT_MAP.get(suffix) + 1);
            } else {
                COUNT_MAP.put(suffix, 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = COUNT_MAP.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }
}
