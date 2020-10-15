package com.lanzycode.pool;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {
    public static void main(String[] args) {
        CountDownLatch cd=new CountDownLatch(2);
        new Ming(cd).start();
        new Wang(cd).start();
        new Ba(cd).start();
    }
}
class Ming extends Thread{
    private CountDownLatch cd;

    public Ming(CountDownLatch cd) {
        this.cd=cd;
    }

    @Override
    public void run() {
        System.out.println("等待还球");
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Wang extends Thread{
    private CountDownLatch cd;

    public Wang(CountDownLatch cd) {
        this.cd=cd;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小王练习了"+(i+1)+"个球");
            cd.countDown();
        }
    }
}
class Ba extends Thread{
    private CountDownLatch cd;

    public Ba(CountDownLatch cd) {
        this.cd=cd;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("小八练习了" + (i + 1) + "个球");
            cd.countDown();
        }
    }
}