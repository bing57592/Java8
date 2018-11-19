package com.ysu._02_thread.highlevel._06_jucutils;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号量
 * 在信号量上我们定义两种操作：
 * acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），要么一直等下去，直到有线程释放信号量，或超时。
 * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * created by bing57592
 * 2018-11-04 21:29
 */
public class _03_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟有3个停车位
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();// 该线程获取信号量
                    System.out.println(Thread.currentThread().getName() + "\t占据车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(20));
                    System.out.println(Thread.currentThread().getName() + "***离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();// 该线程释放信号量
                }
            }, String.valueOf(i)).start();
        }
    }
}
