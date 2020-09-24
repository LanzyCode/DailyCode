package com.itheima.demo;

interface Inner {
    void show1();

    void show2();
}

public class Outer {
    public static void main(String[] args) {
        useInner(new Inner() {
            @Override
            public void show1() {
                System.out.println("1");
            }

            @Override
            public void show2() {
                System.out.println("2");
            }
        });
    }

    public static void useInner(Inner inner) {
        inner.show1();
        inner.show2();

    }
}
