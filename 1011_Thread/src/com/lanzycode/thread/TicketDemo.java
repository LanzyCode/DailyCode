package com.lanzycode.thread;

public class TicketDemo implements Runnable {
    private int count = 100;
    //创建令牌：可以为任意对象
    private Object obj = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (obj) {
                if (count > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖了" + (i + 1) + "张" + "还剩" + count-- + "张");
                }
            }

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
