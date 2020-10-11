package com.lanzycode.thread;
/*
    1.4 题目四
	请使用继承Thread类的方式定义两个线程，一个线程可以计算1--100所有数字的累加和，另一个线程可以计算1--1000所有数字的累加和，每个线程计算完毕后各自打印计算结果，格式例如：”xxx线程计算1--100的累加和，结果：xxxx”
	请定义测试类，并定义main()方法，启动两个线程，观察控制台打印结果。
	*/
public class ThreadDemo02 extends Thread {
    private int sum=0;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName()+"线程计算1--100的累加和结果："+sum);
    }
}
class ThreadDemoAdd extends Thread{
    private int sum=0;
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sum+=i;

        }
        System.out.println(Thread.currentThread().getName()+"线程计算1--1000的累加和结果："+sum);
    }
}
class AddDemo{
    public static void main(String[] args) {
        new Thread(new ThreadDemo02()).start();
        new Thread(new ThreadDemoAdd()).start();
    }
}