package com.ysu._02_thread.base.threadpool;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by bing57592
 * 2018-11-03 18:10
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        CompletionService cs = new ExecutorCompletionService(service);

        cs.submit(() -> {
            return null;
        });

    }
}
