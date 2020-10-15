package com.lanzycode.tcppool;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.logging.SocketHandler;

public class FileUploadPool implements Runnable{
    private final Socket socket;

    public FileUploadPool(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedInputStream bis=null;
                //由于要接受客户端数据所以需要缓冲输入流
        try {
            bis=new BufferedInputStream(socket.getInputStream());
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        //需要写入新文件中，需要创建字节缓冲输出流写入文件

    }
}
