package com.ysu._02_thread.highlevel.loopnotify;

import com.ysu._00_common.util.MyStringUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by bing57592
 * 2018-11-04 16:12
 */
public class LoopRound {

    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int currentLoop) {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                MyStringUtils.print("线程: ? \t打印AA第 ? 次  \t当前第 ? 圈", new Object[]{Thread.currentThread().getName(), i + 1, currentLoop + 1});
            }
            flag = 2;
            c2.signal(); // 唤醒c2
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int currentLoop) {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                MyStringUtils.print("线程: ? \t打印BB第 ? 次  \t当前第 ? 圈", new Object[]{Thread.currentThread().getName(), i + 1, currentLoop + 1});
            }
            flag = 3;
            c3.signal(); // 唤醒c3
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int currentLoop) {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {

                MyStringUtils.print("线程: ? \t打印CC第 ? 次  \t当前第 ? 圈", new Object[]{Thread.currentThread().getName(), i + 1, currentLoop + 1});
            }
            flag = 1;
            c1.signal(); // 唤醒c1
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
