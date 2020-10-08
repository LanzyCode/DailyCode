package com.lanzycode.demo;

interface Flyable {
    void fly();
}

public class p1 {
    public static void main(String[] args) {
        useFly(getFly());
    }

    public static void useFly(Flyable flyable) {
        flyable.fly();
    }

    public static Flyable getFly() {
        return () -> System.out.println("fly");
    }
}
