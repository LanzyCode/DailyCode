package com.lanzycode.thread;

import com.lanzycode.domain.Cooker;
import com.lanzycode.domain.Desk;
import com.lanzycode.domain.Foodie;

public class ConsumerDemo {
    public static void main(String[] args) {
        Desk desk=new Desk();

        Cooker ck=new Cooker(desk);
        Foodie fd=new Foodie(desk);

        new Thread(ck).start();
        new Thread(fd).start();
    }
}
