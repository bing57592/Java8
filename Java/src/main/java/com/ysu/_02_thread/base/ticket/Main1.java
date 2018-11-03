package com.ysu._02_thread.base.ticket;

/**
 * created by bing57592
 * 2018-11-02 23:19
 */
public class Main1 {
    public static void main(String[] args) {
        Window1 window = new Window1(100);
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);
        Thread t4 = new Thread(window);
        Thread t5 = new Thread(window);
        Thread t6 = new Thread(window);
        Thread t7 = new Thread(window);
        Thread t8 = new Thread(window);
        Thread t9 = new Thread(window);


        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t4.setName("t4");
        t5.setName("t5");
        t6.setName("t6");
        t7.setName("t7");
        t8.setName("t8");
        t9.setName("t9");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();

    }
}
