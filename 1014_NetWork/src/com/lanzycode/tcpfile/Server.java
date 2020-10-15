package com.lanzycode.tcpfile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器socket对象，指定监听端口
        ServerSocket serverSocket=new ServerSocket(10000);
        //2.调用阻塞方法等待客户端连接
        while (true) {
            Socket socket = serverSocket.accept();
            //由于要接受客户端数据所以需要缓冲输入流
            BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
            //需要写入新文件中，需要创建字节缓冲输出流写入文件
            String replace = UUID.randomUUID().toString().replace("-", "");
            BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(new File("1014_NetWork/upload",replace+".jpg")));
            //循环读取数据
            int b;
            while((b=bis.read())!=-1){
                bos.write(b);
                bos.flush();
            }
            //需要传回成功给客户端
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("成功");
            bw.newLine();
            bw.flush();
            socket.close();

        }
    }
}
