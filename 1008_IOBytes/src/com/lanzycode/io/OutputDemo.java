package com.lanzycode.io;

import java.io.*;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("1008_IO/a.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("1008_IO/b.txt"));
        int b;
        while((b=bis.read())!=-1){
            bos.write(b);
        }
         bis.close();
         bos.close();
    }
}
