package com.lanzycode.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "在执行了"));
        executorService.shutdown();
    }
}
