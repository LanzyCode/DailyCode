package com.lanzycode.charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("1009_IOTwo/a.txt"));
//        char[] chars=new char[1024];
//        int res = br.read();
//        System.out.println(chars);
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
