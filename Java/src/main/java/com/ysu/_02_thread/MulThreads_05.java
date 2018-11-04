package com.ysu._02_thread;

import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.FutureTask;

/**
 * created by bing57592
 * 2018-11-04 19:12
 */
public class MulThreads_05 {
    public static void main(String[] args) {
        new Thread(new FutureTask<Object>(() -> {
            MyThreadUtils.sleep(10000);
            return new Object();
        })).start();

        new Thread(new FutureTask<Object>(() -> {
            MyThreadUtils.sleep(10000);
            return new Object();
        })).start();

        new Thread(new FutureTask<Object>(() -> {
            MyThreadUtils.sleep(10000);
            return new Object();
        })).start();

        new Thread(new FutureTask<Object>(() -> {
            MyThreadUtils.sleep(10000);
            return new Object();
        })).start();


    }
}
