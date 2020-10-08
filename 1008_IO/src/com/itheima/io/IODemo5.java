package com.itheima.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1008_IO/a.txt");
        FileOutputStream fos = new FileOutputStream("1008_IO/b.txt");
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
