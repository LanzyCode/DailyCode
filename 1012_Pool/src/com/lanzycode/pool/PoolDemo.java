package com.lanzycode.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName()+"在执行了");
        });
        Thread.sleep(2000);
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName()+"在执行了");
        });
        executorService.shutdown();
    }
}
