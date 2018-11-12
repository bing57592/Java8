package com.ysu._02_thread.highlevel._06_jucutils;

import com.ysu._00_common.util.MyStringUtils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier 循环屏障
 * 的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。线程进入屏障通过CyclicBarrier的await()方法。
 * created by bing57592
 * 2018-11-04 21:37
 */
public class _02_CyclicBarrier {
    public static void main(String[] args) {
        int NUMBER = 7;
        CyclicBarrier cb = new CyclicBarrier(NUMBER, () -> {
            System.out.println("################召唤神龙");
        });

        for (int i = 1; i <= NUMBER; i++) {
            int tempI = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(20));
                    MyStringUtils.println("线程 ? 运行结束", new Object[]{Thread.currentThread().getName()});

                    // 线程调用该方法, 进入屏障内. 当屏障内线程数达到阈值时, 屏障开门.
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
