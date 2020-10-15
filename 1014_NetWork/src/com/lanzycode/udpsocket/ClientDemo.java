package com.lanzycode.udpsocket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        DatagramSocket ds=new DatagramSocket();
        while (true) {
            String s=sc.nextLine();
            if (s.equals("886")){
                break;
            }
            byte[] bytes=s.getBytes();
            InetAddress ia=InetAddress.getByName("127.0.0.1");
            int port=10000;
            DatagramPacket dp=new DatagramPacket(bytes,bytes.length,ia,port);
            ds.send(dp);
        }
        ds.close();
    }
}
