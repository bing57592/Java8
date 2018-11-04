package com.ysu._02_thread.highlevel;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程卖票
 * 1. 线程    操作  资源类
 * 2. 高内聚   低耦合
 * 结论: 资源类自身以高内聚的方法,  自身携带同步方法, 对外暴露给多线程调用.
 * created by bing57592
 * 2018-11-03 20:44
 */
public class Window {
    private int ticket;

    // 可重入锁
    private Lock lock = new ReentrantLock();

    public Window() {
    }

    public Window(int ticket) {
        this.ticket = ticket;
    }

    public void sale() {

        lock.lock();
        try {
            if (ticket > 0) {
                MyStringUtils.print("? 卖出 1 张票, 当前剩余 ? 张票", new Object[]{Thread.currentThread().getName(), --ticket});
                MyThreadUtils.sleep(0);
            }
        } finally {
            lock.unlock();
        }

    }

}
