package com.lanzycode.tcpsocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket ss=new Socket("127.0.0.1",44444);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(ss.getOutputStream()));
        bw.write("这是客户端发来的数据");
        bw.flush();
        ss.close();
    }
}
