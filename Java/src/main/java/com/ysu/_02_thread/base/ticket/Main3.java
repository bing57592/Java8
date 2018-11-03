package com.ysu._02_thread.base.ticket;

/**
 * created by bing57592
 * 2018-11-03 10:30
 */
public class Main3 {
    public static void main(String[] args) {
        Window3 window1 = new Window3(100);
        Window3 window2 = new Window3(100);
        Window3 window3 = new Window3(100);

        window1.start();
        window2.start();
        window3.start();
    }
}
