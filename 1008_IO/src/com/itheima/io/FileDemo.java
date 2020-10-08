package com.itheima.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file1 = new File("1008_IO/aaa/bbb");
        file1.mkdir();
        File file2 = new File(file1, "a.txt");
        file2.createNewFile();
        File[] files = file1.listFiles();
        for (File srcFolder : files) {
            if (srcFolder.isFile()) {
                srcFolder.delete();
            } else {
                file1.delete();
            }

        }
    }
}
