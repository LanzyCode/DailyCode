package com.lanzycode;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class network {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia=InetAddress.getLocalHost();
        System.out.println(ia);
        InetAddress ib=InetAddress.getByName("www.baidu.com");
        System.out.println(ib);

    }
}
