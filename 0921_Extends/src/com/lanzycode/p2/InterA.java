package com.lanzycode.p2;

public interface InterA {
    static void show() {
        System.out.println("A.show");
    }

    public default void start() {
        log();
        System.out.println("open");
    }

    public default void end() {
        log();
        System.out.println("end");
    }

    default void log() {
        System.out.println("日志记录");
    }

    public static void open() {
        note();
        System.out.println("O");
    }

    public static void close() {
        note();
        System.out.println("C");
    }

    static void note() {
        System.out.println("校验");

    }
}
