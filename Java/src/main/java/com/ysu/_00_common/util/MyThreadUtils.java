/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu._00_common.util;

/**
 * Created by 陈宪东 on 2018/10/23 10:48
 */
public class MyThreadUtils {

    public static long time() {
        return System.currentTimeMillis();
    }

    /**
     * 线程休眠, 单位毫秒
     *
     * @param milliseconds
     */
    public static void sleep(long milliseconds) {
        if (milliseconds <= 0) return;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程挂起, 释放锁资源, 在线程通信中使用. (主要是因为try-catch) 太难看了.
     *
     * @param object
     */
    public static void wait(Object object) {
        try {
            // 一旦进入此方法, [当前线程]进入阻塞状态. 同时释放同步监视器.
            // 与sleep()相比, wait()会释放锁,而sleep()不会.
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭虚拟机, 用户(其实就是我)忘记关闭虚拟机导致笔记本(就是我的 MacBook Pro) 风扇转速过高.
     */
    public static void stopJVM() {
        stopJVM(20000);
    }

    public static void stopJVM(long millisecond) {
        sleep(millisecond);
        System.out.println("***** 时间过长, 虚拟机自动关闭了!!! *****");
        System.exit(1);
    }

}
