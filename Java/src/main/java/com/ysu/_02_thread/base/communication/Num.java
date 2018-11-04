package com.ysu._02_thread.base.communication;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

/**
 * created by bing57592
 * 2018-11-03 17:10
 */
public class Num implements Runnable {
    private int nums;

    public Num(int nums) {
        this.nums = nums;
    }

    public Num() {
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();// 这里默认是this.notifyAll(), wait() 和 notify() 亦然
                if (nums < 100) {
                    MyStringUtils.print("? 存入银行1块钱, 当前余额 = ? ", new Object[]{Thread.currentThread().getName(), ++nums});
                    MyThreadUtils.sleep(2000);
                    MyThreadUtils.wait(this);
                }
            }
        }
    }

    public synchronized void inc() {
        MyStringUtils.print("? 存入银行1块钱, 当前余额 = ? ", new Object[]{Thread.currentThread().getName(), ++nums});
    }
}
