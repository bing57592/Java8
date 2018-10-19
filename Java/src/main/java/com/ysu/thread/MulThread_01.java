package com.ysu.thread;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * created by bing57592
 * 2018-10-11 13:57
 */
public class MulThread_01 {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService cs = new ExecutorCompletionService(executorService);

        long start = System.currentTimeMillis();
        cs.submit(() -> {
            call_01();
            return null;
        });
        cs.submit(() -> {
            call_02();
            return null;
        });
        cs.submit(() -> {
            call_03();
            return null;
        });
        cs.submit(() -> {
            call_04();
            return null;
        });

        cs.poll(10,TimeUnit.DAYS);
        long end = System.currentTimeMillis();
        System.out.println("一共花费了: " + (end - start) + "秒");
        executorService.shutdown();
    }

    public static void call_01() throws Exception {
        Thread.sleep(1000);
        System.out.println(1);
    }

    public static void call_02() throws Exception {
        Thread.sleep(1000);
        System.out.println(2);
    }

    public static void call_03() throws Exception {
        Thread.sleep(1000);
        System.out.println(3);
    }

    public static void call_04() throws Exception {
        Thread.sleep(1000);
        System.out.println(4);
    }

    @Test
    public void test1() {
        new Thread(() -> {
            System.out.println("hello");
        }).start();
    }
}
