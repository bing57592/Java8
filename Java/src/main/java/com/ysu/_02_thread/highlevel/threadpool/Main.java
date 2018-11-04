package com.ysu._02_thread.highlevel.threadpool;

import com.ysu._00_common.util.MyMathUtils;
import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Java进行多线程操作的第四种方式: 线程池ThreadPool
 * Collections, Arrays, Executors
 * <p>
 * created by bing57592
 * 2018-11-04 17:39
 */

public class Main {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future<Integer> submit = null;
        try {
            for (int i = 0; i < 10; i++) {
                final int index = i;
                /**
                 * 虽然这里用多线程实现了功能, 但是本质还是串行的.
                 */
                submit = pool.submit(() -> {
                    MyStringUtils.print("当前线程: ? ", new Object[]{Thread.currentThread().getName()});
                    MyThreadUtils.sleep(MyMathUtils.randomInt(1000, 2000));
                    return MyMathUtils.randomInt(10, 20);
                });
                System.out.println(submit.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
