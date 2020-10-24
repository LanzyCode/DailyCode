package com.lanzycode.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private final Socket socket;
    private static final Logger LOGGER= LoggerFactory.getLogger(ServerThread.class);

    public ServerThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        synchronized (MainAppServer.LOCK){
            //获取到成员变量Socket的输入流用于读取客户端送来的请求数据。
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
                String requestData = br.readLine();
                //调用拆分数据方法对本次请求编号进行获取
                String[] requestInfo=getRequestData(requestData);

                switch (requestInfo[0]){
                    case "1":
                        addStudent(bw,requestInfo[1]);
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    default:
                        LOGGER.error("[服务器端]客户端本次请求的数据非法");

                }
            } catch (IOException e) {
                LOGGER.error("[服务器端]获取Socket流对象失败");
            }

        }
    }

    private void addStudent(BufferedWriter bw, String studentInfo) {
        StudentDao.addStudent(studentInfo);
        try {
            bw.write("成功");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            LOGGER.error("失败");
        }

    }

    private String[] getRequestData(String requestData) {
        String[] infos=new String[2];
        String[] splitResult = requestData.split("INFO:");
        infos[0] = String.valueOf(splitResult[0].charAt(1));
        if (splitResult.length==2){
            infos[1]=splitResult[1];
        }
        return infos;

    }
}
