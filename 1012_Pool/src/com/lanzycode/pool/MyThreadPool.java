package com.lanzycode.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                2,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        //核心线程数量，最大线程数，空闲线程存活时间，时间，人物队列，创建线程工厂，任务拒绝策略
        for (int i = 0; i < 16; i++) {
            threadPoolExecutor.submit(() -> System.out.println(Thread.currentThread().getName() + "被执行了"));
        }

        threadPoolExecutor.shutdown();
    }
}
