package com.itheima.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("1008_IO/test.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
        String str = "我爱你\n";
        byte[] bytes = str.getBytes();
        fos.write(bytes);
        fos.write(bytes);
        fos.write(bytes);
        fos.close();
//      file.delete();
    }
}
