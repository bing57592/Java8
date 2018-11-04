package com.ysu._02_thread.highlevel._01_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Runnable 和 Callable的异同
 * 1. 实现的方法不同: Runnable: run();  Callable: call()
 * 2. 是否带返回值: Runnable: 不带返回值;  Callable: 带返回值;
 * 3. 是否可以抛异常: Runnable: 不可抛异常;  Callable: 可以抛异常;
 * created by bing57592
 * 2018-11-04 10:23
 */
public class Main {
    public static void main(String[] args) throws Exception {

        // 1. 创建一个线程任务
        FutureTask<Long> task = new FutureTask<Long>(() -> {
            System.out.println("callable");
            return System.currentTimeMillis();
        });

        // 2. 启动这个任务线程
        new Thread(task).start();

        // 3. 获取任务线程的返回值
        // PS: 一个FutureTask无论几个线程调用, 只会取一个线程的调用结果(return的内容)
        System.out.println(task.get());
        Thread.sleep(1000);
        System.out.println(task.get());
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {

    }
}