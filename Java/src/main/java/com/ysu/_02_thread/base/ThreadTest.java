package com.ysu._02_thread.base;

import com.ysu._00_common.util.MyThreadUtils;
import lombok.Data;

/**
 * 创建一个线程, 遍历100以内的偶数
 * 一. 继承Thread的方式
 * 1. 提供一个继承于Thread类的子类.
 * 2. 重写Thread类的run(): 将创建的线程想要执行的操作, 声明在run()中.
 * 3. 实例化Thread子类
 * 4. 调用子类对象的start().
 * <p>
 * 二. 线程中常用方法:
 * 1. yield(): 当前线程调用此方法, 释放cpu资源, 然后和其他线程共同争抢cpu资源.
 * ** 所以会出现: 分线程yield()之后, 随后的执行执行的依然是分线程, 这是正常的.
 * 2. join(): 在线程a中, 调用线程b的join()方法, 线程a会阻塞, 线程b会插队, 直到线程b执行完所有方法.
 * 3. sleep(long millitimes): 让当前的线程睡眠多少毫秒
 * created by bing57592
 * 2018-11-02 21:13
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new subThread());
        thread.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + i);
            // 当在主线程中, 调用分线程的join()方法
            if (i % 20 == 0) thread.join();
        }
    }
}

@Data
class subThread extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("subThread");
        for (int i = 0; i < 100; i++) {
            MyThreadUtils.sleep(1000);
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + i);
        }

    }

}