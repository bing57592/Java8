package com.ysu._02_thread.highlevel._06_jucutils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 多线程的辅助类 --- 线程计数器: CountDownLatch Count-计数, Down-减法, Latch-门闩
 * 多线程的辅助类 --- 循环屏障: CyclicBarrier Cyclic-循环的, Barrier-屏障
 * created by bing57592
 * 2018-11-04 19:22
 */
public class Main {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(6);
    }
}
