package com.lanzycode.tcpfile;

import java.io.*;
import java.net.Socket;
import java.util.logging.SocketHandler;

public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建socket对象 连接服务器，传入IP和端口
        Socket socket=new Socket("127.0.0.1",10000);
        //2.写输入流读取文件
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("1014_NetWork/timg.jpeg"));
        //3.将客户端读取的数据发送给服务器端，需要缓冲输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        int b;
        while((b=bis.read())!=-1){
            bos.write(b);
            bos.flush();
        }

        socket.shutdownOutput();
        //4.读取服务器的成功信息,字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = br.readLine();
        System.out.println("服务器反馈的数据是"+s);

        bis.close();
        socket.close();


    }
}
