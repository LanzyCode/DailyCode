package com.lanzycode.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter=new FileWriter("1009_IOTwo/a.txt");
        fileWriter.write("你好");
        fileWriter.flush();
    }
}
