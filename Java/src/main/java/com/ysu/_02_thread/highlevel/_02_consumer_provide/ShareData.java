package com.ysu._02_thread.highlevel._02_consumer_provide;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目: 现在有两个线程, 可以操作同一个变量, 实现一个线程对该变量加1, 一个变量对该变量减1. 实现交替.
 * **** 五轮, 初始变量为0;
 * ***
 * 多线程干活: 1. 判断;  2. 唤醒;  3. 干活;
 *
 * desc() && desc2(), 一个是jdk1.5之前的实现方式, 一个是1.5新增的实现方式.
 * 目前还不清楚用juc下的ReentrantLock, 与synchronized相比, 有什么优势...
 * created by bing57592
 * 2018-11-04 12:48
 */
public class ShareData {
    int num = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void desc2() {
        lock.lock();
        try {
            while (num == 0)
                condition.await();
            MyThreadUtils.sleep(20);
            MyStringUtils.print("当前线程 = ? ; 当前结果 = ?", Thread.currentThread().getName(), --num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void insc2() {
        lock.lock();
        try {
            while (num == 1)
                condition.await();
            MyThreadUtils.sleep(20);
            MyStringUtils.print("当前线程 = ? ; 当前结果 = ?", Thread.currentThread().getName(), ++num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 下面标注@Deprecated的方法, 是jdk5 之前, 实现线程通信的方法. 现在要get新技能
    @Deprecated
    public synchronized void insc() {
        if (num == 1)
            MyThreadUtils.wait(this);

        MyThreadUtils.sleep(100);
        MyStringUtils.print("当前线程 = ? ; 当前结果 = ?", Thread.currentThread().getName(), ++num);
        notifyAll();
    }

    @Deprecated
    public synchronized void desc() {
        if (num == 0)
            MyThreadUtils.wait(this); // 如果不满足条件, 线程停滞.

        MyStringUtils.print("当前线程 = ? ; 当前结果 = ?", Thread.currentThread().getName(), --num);
        notifyAll();// 工作之后, 唤醒其他线程.
    }


}
