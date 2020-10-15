package com.lanzycode.p2;

public interface InterA {
    static void show() {
        System.out.println("A.show");
    }

    default void start() {
        log();
        System.out.println("open");
    }

    default void end() {
        log();
        System.out.println("end");
    }

    default void log() {
        System.out.println("日志记录");
    }

    static void open() {
        note();
        System.out.println("O");
    }

    static void close() {
        note();
        System.out.println("C");
    }

    static void note() {
        System.out.println("校验");

    }
}
