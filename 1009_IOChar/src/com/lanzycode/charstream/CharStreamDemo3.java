package com.lanzycode.charstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("1009_IOTwo/a.txt");
        char[] chars=new char[1024];
        int res1 = fileReader.read(chars);
        System.out.println(chars);
        System.out.println(res1);
        fileReader.close();
    }
}
