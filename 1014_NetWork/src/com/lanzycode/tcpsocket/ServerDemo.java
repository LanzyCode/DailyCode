package com.lanzycode.tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(44444);
        System.out.println("已经开始监听");
        //阻塞方法，一直在监听，有客户端链接时候返回socket对象，获取
        Socket accept = ss.accept();
        BufferedReader bf=new BufferedReader(new InputStreamReader(accept.getInputStream()));
        System.out.println(bf.readLine());
    }
}
