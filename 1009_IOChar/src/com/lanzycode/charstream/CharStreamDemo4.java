package com.lanzycode.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamDemo4 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("清输入用户名");
        String userName=sc.nextLine();
        System.out.println("请输入密码");
        String passWord=sc.nextLine();

        FileWriter fr=new FileWriter("1009_IOTwo/a.txt",true);
        fr.write(userName+"\n"+passWord+"\n");
        fr.flush();
    }
}
