package com.lanzycode.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo6 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("1009_IOTwo/a.txt"));
        bw.write("嘻嘻嘻");
        bw.newLine();
        bw.write("哈哈哈");
        bw.flush();

    }
}
