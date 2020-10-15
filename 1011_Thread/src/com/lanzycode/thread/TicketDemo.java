package com.lanzycode.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketDemo implements Runnable {
    private int count = 100;
    //创建令牌：可以为任意对象
    private final Object obj = new Object();
    private final Lock lock=new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //同步代码块上锁并自动解锁
//            synchronized (obj) {
            try {
                lock.lock();
                if (count > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖了" + (i + 1) + "张" + "还剩" + count-- + "张");
                }

            } finally {
                lock.unlock();
            }
//            }

        }
    }
}

class Ticket {
    public static void main(String[] args) {
        TicketDemo tk = new TicketDemo();
        new Thread(tk, "窗口1").start();
        new Thread(tk, "窗口2").start();
        new Thread(tk, "窗口3").start();
    }
}
