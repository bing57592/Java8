package com.ysu._02_thread.threadsafe;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.*;

/**
 * created by bing57592
 * 2018-11-03 18:30
 */
public class MulThraeds_05 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService completionService = new ExecutorCompletionService(executorService);

        long start = MyThreadUtils.time();
        completionService.submit(() -> {
            System.out.println(1);
            MyThreadUtils.sleep(1000);
            return null;
        });

        completionService.submit(() -> {
            System.out.println(2);
            MyThreadUtils.sleep(1000);
            return null;
        });

        completionService.submit(() -> {
            System.out.println(3);
            MyThreadUtils.sleep(1000);
            return null;
        });

        for (int i = 0; i < 3; i++) {
            try {
                completionService.poll(10, TimeUnit.DAYS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = MyThreadUtils.time();


        try {
            completionService.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyStringUtils.print("共花费了 ? 毫秒", end - start);


    }
}
