package com.lanzycode.io;

import java.io.*;

public class IODemo6 {
    private static final File SRC_FILE = new File("1008_IO/a.txt");
    private static final File DES_FILE = new File("1008_IO/a-copy4.txt");

    public static void main(String[] args) throws IOException {
        //字节流
//        long time=StreamWithByte(SRC_FILE,DES_FILE);
//        System.out.println(time);
        //字节数组流
        //缓冲字节流
        //缓冲字节数组流
        long time4 = BufferStreamWithByteArray(SRC_FILE, DES_FILE);
        System.out.println(time4);
    }

    private static long BufferStreamWithByteArray(File srcFile, File desFile) throws IOException {
        long startTime = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long StreamWithByte(File srcFile, File desFile) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
