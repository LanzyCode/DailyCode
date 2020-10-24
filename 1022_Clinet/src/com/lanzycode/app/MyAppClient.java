package com.lanzycode.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyAppClient {
        private static final Logger LOGGER= LoggerFactory.getLogger(MyAppClient.class);
        private static final Scanner SCANNER=new Scanner(System.in);
        private static final String IP="127.0.0.1";
        private static final Integer PORT=10000;

    public static void main(String[] args) {
        while(true){
            System.out.println("*************************************************************");
            System.out.println("*\t1.添加学员\t2.修改学员\t3.删除学员\t4.查询学员\t5.退出\t*");
            System.out.println("*************************************************************");
            String choose = SCANNER.nextLine();
            switch (choose){

                    case "1":
                        addStudent();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        LOGGER.info("[客户端]用户退出");
                        System.exit(0);
                        break;
                    default:
                        LOGGER.warn("[客户端]用户本次输入的" + choose + "参数非法.");
                        break;

            }
        }
    }

    private static void addStudent() {
        //获取对应的socket对象判断是否为空
        Socket socket=getConnection();
        if (socket==null){
            LOGGER.warn("[客户端]无SOCKET对象");
            return;
        }
        //获取SOCKET输出流并封装，获取Socket的输出流并封装
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            //录入学生信息
            System.out.println("请输入要录入的学生的姓名:");
            String studentName = SCANNER.nextLine();
            System.out.println("请输入要录入的学生的性别:");
            String studentGender = SCANNER.nextLine();
            System.out.println("请输入要录入的学生的年龄:");
            String studentAge = SCANNER.nextLine();
            //封装数据为请求类型的数据->[1]张三,男,23
            bw.write("[1]INFO:"+studentName+studentGender+studentAge);
            bw.newLine();
            bw.flush();
            //接收服务器返回的结果并打印
            System.out.println(br.readLine());
            //关闭socket
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Socket getConnection() {
        Socket socket=null;
        try {
            new Socket(IP,PORT);
        } catch (IOException e) {
            LOGGER.warn("[客户端]获取socket连接对象时发生错误");
        }
        return socket;
    }
}
