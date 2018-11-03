package com.ysu._02_thread.base.communication;

import com.ysu._00_common.util.MyThreadUtils;

/**
 * 线程的通信:
 * wait(): 等待. 一个线程在执行过程中, 一旦调用此方法, 则此线程进入阻塞状态, 等待其他线程来唤醒自己.
 * notify(): 唤醒. 一个线程在执行过程中, 一旦调用此方法, 则会唤醒调用了wait()方法的一个线程.
 * notifyAll(): 唤醒. 一个线程在执行过程中, 一旦调用此方法, 则会唤醒调用了wait()方法的所有线程. 高优先级的要优先被唤醒.
 * <p>
 * 上述三个方法使用时的注意点:
 * 1. 此三个方法必须使用在同步中.
 * 2. 此三个方法的调用者是同步监视器而不是线程.
 * 3. 此三个方法是定义在Object类中的.
 * created by bing57592
 * 2018-11-03 17:12
 */
public class Main {
    public static void main(String[] args) {
        Num num = new Num();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);
        t1.setName("A");
        t2.setName("B");

        t1.start();
        t2.start();

        MyThreadUtils.stopJVM();
    }
}
