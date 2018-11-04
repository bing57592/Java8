package com.ysu._02_thread.highlevel._04_writelock;

/**
 * 读写锁: 一个线程写, 100个线程读.
 * 当writeLock.lock()的时候, 也即写锁上锁了之后, 是不允许读的. (而不是读到旧数据).
 * 这样的话, 读线程就被阻塞了.
 * created by bing57592
 * 2018-11-04 16:39
 */
public class Main {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
//        new Thread(() -> {
//            while (true) {
//                MyThreadUtils.sleep(1000);// 每秒钟读取一次sum值
//                mq.readObj();
//            }
//        }, "Thread-监控").start();


        // 证明一下读锁与读锁不互斥.
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                mq.readObj();
            }, String.valueOf(i)).start();
        }
    }
}
