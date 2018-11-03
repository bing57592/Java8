package com.ysu._02_thread.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by bing57592
 * 2018-11-03 18:06
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        service.submit(() -> System.out.println("这是第一个线程"));
        service.submit(() -> System.out.println("这是第二个线程"));
        service.submit(() -> System.out.println("这是第三个线程"));
    }
}
