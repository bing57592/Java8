package com.ysu._02_thread.highlevel._03_loopnotify;

/**
 * Java多线程循环调用: 实现 A -> B -> C -> A...
 * 三个线程启动, 要求如下:
 * AA打印5次, BB打印10次, CC打印15次, 循环20次
 * created by bing57592
 * 2018-11-04 16:08
 */
public class Main {
    public static void main(String[] args) {
        LoopRound loopRound = new LoopRound();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                loopRound.print5(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                loopRound.print10(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                loopRound.print15(i);
            }
        }).start();
    }
}
