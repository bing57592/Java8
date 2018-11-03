package com.ysu._02_thread.base.ticket;

import com.ysu._00_common.util.MyThreadUtils;
import lombok.Data;

/**
 * 模仿车站买票程序. 开启3个窗口卖票. 总票数100张.
 * 1. 问题: 出现了重票和错票
 * 2. 出现问题的原因: 一个窗口在没有售完票的情况下, 其他的窗口参与进来, 操作ticket, 导致ticket输出的错误.
 * 3. 解决的方案: 当某一个窗口完全操作完ticket以后, 其他窗口才应该被允许进来, 继续操作ticket.
 * 4. java如何实现? 同步机制: 同步代码块. 同步方法.
 * ** 4.1 synchronized(同步监视器-monitor){需要被同步的代码}
 * ** ①: 需要被同步的代码, 即为操作共享数据的代码.
 * ** ②: 共享数据: 多个线程共同操作的数据.
 * ** ③: 同步监视器: 俗称锁, 可以有任何一个类的对象来充当.
 * ** ④: 要求: 保证多个线程用同一把锁.
 * <p>
 * 5. 线程的同步机制, 解决了线程的安全问题.
 * 6. 好处: 线程的同步机制, 解决了线程的安全问题.
 * 7. 劣势: 在操作共享数据过程中, 是单线程的.
 * created by bing57592
 * 2018-11-02 22:53
 */
@Data
public class Window1 implements Runnable {
    private int tickets;
    Object obj = new Object();

    public Window1(int tickets) {
        this.tickets = tickets;
    }


    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                MyThreadUtils.sleep(10);
                System.out.println(Thread.currentThread().getName() + " - 剩余票数: " + --tickets);
            } else {
                break;
            }
        }
    }
}
