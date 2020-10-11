package com.lanzycode.thread;
/*
1.2 题目二
	请使用实现Runnable接口的方式定义一个类，在run()方法中使用循环变量i遍历1--1000所有的数字。
	定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。
	请观察控制台打印，i和k交叉打印的情况。
*/
class RunnableDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"HelloWorld");
        }
    }
}
class RunnableDemo1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"HelloJava");
        }
    }
}

class Demo01{
    public static void main(String[] args) {
        new Thread(new RunnableDemo(),"线程1").start();
        new Thread(new RunnableDemo1(),"线程2").start();
    }
}
