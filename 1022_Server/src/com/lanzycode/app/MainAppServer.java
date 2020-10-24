package com.lanzycode.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class MainAppServer {
    private static final Integer PORT = 10000;
    private static final Logger LOGGER=LoggerFactory.getLogger(MainAppServer.class);
    private static final ThreadPoolExecutor EXECUTOR =new ThreadPoolExecutor(5,
            8,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    public static final Object LOCK =new Object();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            LOGGER.info("[服务器端]监听到客户端连接，开始线程执行");
            EXECUTOR.submit(new ServerThread(socket));
        } catch (IOException e) {
            LOGGER.error("[服务器端]创建ServerSocket对象失败");
        }
    }
}
