package com.lanzycode.thread;

import javax.xml.namespace.QName;

public class ThreadNameDemo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+getName());
        }
    }
    public ThreadNameDemo() {

    }

    public ThreadNameDemo(String name) {
        super(name);
    }

}
class NameDemo{
    public static void main(String[] args) {
        ThreadNameDemo td1=new ThreadNameDemo();
        td1.setName(":在使用第一线程");
        new ThreadNameDemo(":在使用第二线程").start();
        ThreadNameDemo td3=new ThreadNameDemo();
        td3.setName(":在使用第三线程");
        td1.start();
        td3.start();





    }
}
