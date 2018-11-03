package com.ysu._02_thread.base.ticket.exercise1;

/**
 * 练习1:
 * 银行有一个账户.
 * 有两个储户分别向同一个账户存3000元, 每次存1000元, 存3次. 每次存完打印账户余额
 * 问题: 该程序是否有线程安全问题, 如果有, 如何解决?
 * [提示]
 * 1. 明确哪些代码是多线程运行代码, 须写入run()方法.
 * 2. 明确什么是共享数据
 * 3. 明确多线程运行代码中哪些语句是操作共享数据的
 * <p>
 * created by bing57592
 * 2018-11-03 13:41
 */
public class Exercise {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(bank);

        t1.setName("用户S");
        t2.setName("用户B");

        t1.start();
        t2.start();
    }
}
