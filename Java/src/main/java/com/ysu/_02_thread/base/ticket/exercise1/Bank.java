package com.ysu._02_thread.base.ticket.exercise1;

import com.ysu._00_common.util.MyStringUtils;
import com.ysu._00_common.util.MyThreadUtils;

/**
 * created by bing57592
 * 2018-11-03 15:51
 */

public class Bank implements Runnable {
    private int balance;

    public Bank() {
    }

    @Override
    public void run() {
        while (true) {
            incBalance();
        }
    }

    private void incBalance() {
        if (balance < 3000) {
            balance += 10;
            MyStringUtils.print("?  存入1000元, 目前余额 = ? 元.",
                    new Object[]{Thread.currentThread().getName(), balance});
            MyThreadUtils.sleep(10);

        } else return;
    }


}
