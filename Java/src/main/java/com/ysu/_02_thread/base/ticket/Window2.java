package com.ysu._02_thread.base.ticket;

import com.ysu._00_common.util.MyThreadUtils;

/**
 * created by bing57592
 * 2018-11-03 01:54
 */
public class Window2 implements Runnable {

    private int tickets;

    public Window2(int tickets) {
        this.tickets = tickets;
    }

    public Window2() {

    }

    @Override
    public void run() {
        while (true) {
            ticketDesc();
        }
    }

    // 同步方法, 保证同一个时间段内, 只能有一个线程访问方法.
    // 使用同步方法, 解决"实现"方式的线程安全问题.
    // 默认同步方法的锁是当前对象.
    private synchronized void ticketDesc() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " - 剩余票数: " + --tickets);
            MyThreadUtils.sleep(10);
        } else {
            return;
        }
    }
}
