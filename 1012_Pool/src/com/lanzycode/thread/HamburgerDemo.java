package com.lanzycode.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class HamburgerDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> ab = new ArrayBlockingQueue<>(1);
        Object obj=new Object();
        Cook cook = new Cook(ab,obj);
        Foodie foodie = new Foodie(ab,obj);
        new Thread(cook).start();
        new Thread(foodie).start();
    }
}
