package com.lanzycode.thread;

public class TortoiseRabbitDemo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (Thread.currentThread().getName().endsWith("兔子") && i==50){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
    }
}
class TRDemo{
    public static void main(String[] args) {
        new Thread(new TortoiseRabbitDemo(),"兔子").start();
        new Thread(new TortoiseRabbitDemo(),"乌龟").start();
    }
}
