/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu._02_thread;

import com.ysu._00_common.util.MyThreadUtils;
import org.junit.Test;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 陈宪东 on 2018/10/23 10:01
 */
public class MulThreads_02 {
    private static int sum = 0;

    private static AtomicInteger atomicSum = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sum++;
                }
            }).start();
        }

        MyThreadUtils.threadSleep(1000);

        System.out.println(sum);
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletionService cs = new ExecutorCompletionService(executorService);
        for (int i = 0; i < 100000; i++) {
            cs.submit(() -> {
                sum++;
                return sum;
            });
        }
        MyThreadUtils.threadSleep(1000);
        System.out.println(sum);
    }
}
