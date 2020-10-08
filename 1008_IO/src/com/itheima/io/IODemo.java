package com.itheima.io;

import java.io.File;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        //创建文件
        File file = new File("/Users/shawn/Documents/test/a.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
        //创建文件夹
        File file2 = new File("/Users/shawn/Documents/c");
        boolean mkdir = file2.mkdir();
        System.out.println(mkdir);
        //创建多层文件夹
        File file3 = new File("/Users/shawn/Documents/d/b/a");
        boolean mkdirs = file3.mkdirs();
        System.out.println(mkdirs);
        //创建多层文件夹中的新文件
        File file4 = new File("/Users/shawn/Documents/d/b/a", "d.avi");
        boolean newFile1 = file4.createNewFile();
        System.out.println(newFile1);

        boolean delete = file.delete();
        System.out.println(delete);
        boolean delete1 = file2.delete();
        System.out.println(delete1);
        boolean delete2 = file4.delete();
        System.out.println(delete2);
        boolean delete3 = file3.delete();
        System.out.println(delete3);


    }
}
