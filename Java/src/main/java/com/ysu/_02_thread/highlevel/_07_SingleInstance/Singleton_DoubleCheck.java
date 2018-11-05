package com.ysu._02_thread.highlevel._07_SingleInstance;

/**
 * @Author bing57592
 * @Date 2018-11-05 19:59
 */
public class Singleton_DoubleCheck {

    private static volatile Singleton_DoubleCheck singletonDoubleCheck;

    private Singleton_DoubleCheck() {}

    public static Singleton_DoubleCheck getInstance() {
        if (singletonDoubleCheck == null) {
            synchronized (Singleton_DoubleCheck.class) {
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new Singleton_DoubleCheck();
                }
            }
        }
        return singletonDoubleCheck;
    }
}