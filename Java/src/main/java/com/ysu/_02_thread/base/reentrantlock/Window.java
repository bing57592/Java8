package com.ysu._02_thread.base.reentrantlock;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock 的方式, 解决线程安全问题.
 * <p>
 * 同: 解决了线程安全问题.
 * 异:
 * ** 同步的方式: 1. 具有同步监视器的概念; 2. 在线程执行完代码之后, 自动释放.
 * ** Lock的方式: 1. 需要显式地调用unlock()方法, 才能保证其他线程操作共享数据.
 * <p>
 * created by bing57592
 * 2018-11-03 15:53
 */
public class Window implements Runnable {

    int ticket = 100;

    // 可重入锁, 在看<java并发编程>这本书里, 写了这么个东西(但是完全没意义啊)
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 1. 调用锁的lock方法, 可以保证lock 之后的操作只有一个线程来执行.
                lock.lock();
                // 2. 加完锁之后, 处理业务逻辑
                if (ticket > 0) {
                    MyThreadUtils.sleep(10);
                    MyStringUtils.print("? 卖出一张票, 目前剩余票数 ? 张", new Object[]{Thread.currentThread().getName(), --ticket});
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 3. 业务逻辑执行之后, 通过lock.unlock()方法, 对lock解锁.
                lock.unlock();
            }


        }
    }
}
