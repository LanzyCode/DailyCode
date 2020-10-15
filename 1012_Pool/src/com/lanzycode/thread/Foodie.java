package com.lanzycode.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {
    private final ArrayBlockingQueue<String> ab;
    private final Object obj;
    public Foodie(ArrayBlockingQueue ab, Object obj) {
        this.ab = ab;
        this.obj=obj;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                try {
                    String take = ab.take();
                    System.out.println("吃货不断吃" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
