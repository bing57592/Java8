package com.ysu._02_thread;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;
import org.junit.Test;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 看来 newFixedThreadPool() 这种线程池是非阻塞的
 * created by bing57592
 * 2018-11-03 18:21
 */
public class MulThreads_04 {
    public static void main(String[] args) {
        ExecutorService poll = Executors.newFixedThreadPool(2);
        long start = MyThreadUtils.time();
        poll.submit(() -> {
            MyThreadUtils.sleep(1000);
            System.out.println("1");
        });
        poll.submit(() -> {
            MyThreadUtils.sleep(1000);
            System.out.println("2");
        });

        poll.submit(() -> {
            MyThreadUtils.sleep(1000);
            System.out.println("3");
        });
        long end = MyThreadUtils.time();
        MyThreadUtils.sleep(2000);
        MyStringUtils.print("一共花费了 ? 秒", end - start);
        MyThreadUtils.stopJVM();
    }

    @Test
    public void test() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService cs = new ExecutorCompletionService(executorService);
    }
}
