package com.lanzycode.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Cook extends Thread {
    private ArrayBlockingQueue<String> ab;
    private Object obj;

    public Cook(ArrayBlockingQueue ab, Object obj) {
        this.ab = ab;
        this.obj=obj;
    }

    @Override
    public void run() {
            while (true) {
                synchronized (obj) {
                try {
                    ab.put("汉堡包");
                    System.out.println("厨师正在制作...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
