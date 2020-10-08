package com.itheima.io;

import java.io.File;

public class ListFileDemo {
    public static void main(String[] args) {
        //Exist() 判断是否存在
        //isFile() 判断文件是否存在
        //isDirectory() 判断文件夹是否存在
        //getName() 获取文件或文件夹的名称
        //getAbsolutePath() 获取文件或文件夹的绝对路径

        File file = new File("/Users/shawn/Documents");
        System.out.println(file.length());
        File[] files = file.listFiles();
        for (File list : files) {
            System.out.println(list);
        }
    }
}
