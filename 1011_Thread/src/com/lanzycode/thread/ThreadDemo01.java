package com.lanzycode.thread;
/*
1.1 题目一
	请使用继承Thread类的方式定义一个线程类，在run()方法中使用循环变量i遍历1--1000所有的数字。
	定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。
	请观察控制台打印，i和k交叉打印的情况。
*/
public class ThreadDemo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("当前是"+i+"次打印");
        }
    }
}
class Demo{
    public static void main(String[] args) {
        new ThreadDemo01().start();
        new ThreadDemo01().start();
    }
}
