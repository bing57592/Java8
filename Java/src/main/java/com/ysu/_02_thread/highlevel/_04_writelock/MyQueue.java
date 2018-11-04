package com.ysu._02_thread.highlevel._04_writelock;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * created by bing57592
 * 2018-11-04 16:56
 */
public class MyQueue {
    private Integer sum = 10;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void writeObj(int sum) {
        lock.writeLock().lock();
        try {
            MyStringUtils.print("线程 ? \t做了一个写操作", new Object[]{Thread.currentThread().getName()});
            this.sum = sum;
            MyThreadUtils.sleep(10000);// 对sum赋值之后, 过10秒才释放读锁.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyStringUtils.print("休息10秒之后, 释放了写锁");
            lock.writeLock().unlock();
        }
    }

    public void readObj() {
        lock.readLock().lock();
        try {
            MyStringUtils.print("线程 ? \t做了一个读操作, 读到的结果为 ? ", new Object[]{Thread.currentThread().getName(), this.sum});
            MyThreadUtils.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

}
