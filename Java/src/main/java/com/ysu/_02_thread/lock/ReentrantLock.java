/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu._02_thread.lock;

/**
 * 自定义一个<可重入锁><br>
 * Created by 陈宪东 on 2018/10/23 15:10
 */
public class ReentrantLock {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock()
            throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            // 获得该锁的那个线程，获得了多少次该锁（
            // 即调用了几次lock方法，即重入了几次），就得unlock几次，
            // 即lockedCount=0，才会把那些wait（阻塞）的线程唤醒
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
