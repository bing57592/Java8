package com.ysu._02_thread.highlevel;

import com.ysu._00_common.util.MyThreadUtils;

/**
 * 线程高级. PS: 用Highlevel命名, 真是太low了
 * 学习你们新技术:
 * 1. 是什么, 用在哪, 怎么用.
 * 2. 是什么, 能干嘛, 去哪下, 怎么用.
 * 3. JUC:
 * **java.util.concurrent
 * **java.util.concurrent.atomic
 * **java.util.concurrent.locks
 * 4. 并发和并行的区别:
 * 并发: 同一时间段, 多个线程在争抢同一份资源.
 * 并行: 同一时间段,
 * ****
 * 多线程变成:
 * 1. 线程    操作  资源类
 * 2. 高内聚   低耦合
 * 结论: 资源类自身以高内聚的方法,  自身携带同步方法, 对外暴露给多线程调用.
 * created by bing57592
 * 2018-11-03 20:16
 */
public class Main {
    public static void main(String[] args) {
        Window window = new Window(10000);

        new Thread(() -> window.sale()).start();
        new Thread(() -> window.sale()).start();
        new Thread(() -> window.sale()).start();
        new Thread(() -> window.sale()).start();
        new Thread(() -> window.sale()).start();

        MyThreadUtils.stopJVM();
    }
}
