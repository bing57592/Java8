package com.ysu._02_thread.highlevel._06_jucutils;

import com.ysu._00_common.util.MyMathUtils;
import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 线程计数器
 * CountDownLatch Count-计数, Down-减法, Latch-门闩.
 * 让一些线程阻塞, 直到另一些线程完成一系列操作后才被唤醒.
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 * 解释：5个同学陆续离开教室后值班同学才可以关门。
 * main主线程必须要等前面5个线程完成全部工作后，自己才能工作
 * created by bing57592
 * 2018-11-04 21:10
 */
public class _01_CountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch cdl = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                MyThreadUtils.sleep(MyMathUtils.randomInt(1000, 20000));
                MyStringUtils.println("线程 ? 运行结束", new Object[]{Thread.currentThread().getName()});
                cdl.countDown();
            }).start();
        }
        cdl.await();//什么时候变为零了，什么时候走

        System.out.println(Thread.currentThread().getName() + "********秦灭6国，一统华夏");

    }
}
