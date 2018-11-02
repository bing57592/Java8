package com.ysu._02_thread.deadlock;

/**
 * created by bing57592
 * 2018-11-02 09:57
 */

public class DeadLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args){
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}
