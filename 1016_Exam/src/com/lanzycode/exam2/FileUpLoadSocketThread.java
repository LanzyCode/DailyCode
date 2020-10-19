package com.lanzycode.exam2;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class FileUpLoadSocketThread implements Runnable{

    private Socket socket;

    public FileUpLoadSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(socket.getInputStream());
            String result = UUID.randomUUID().toString().replace("-", "");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("1016_Exam/upload", result + ".jpeg")));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("文件上传成功");
            bw.newLine();
            bw.flush();
            bos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
