package com.lanzycode.exam2;

import java.io.*;
import java.net.Socket;

public class Client {
    public void upload() throws IOException {
        Socket socket = new Socket("127.0.0.1", 23333);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1016_Exam/test.jpeg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
            bos.flush();
        }
        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();
        System.out.println(result);
        bis.close();
        socket.close();
    }
}
//使用UUID，测试50个文件上传
class Test {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 50; i++) {
            new Client().upload();
        }
    }
}
