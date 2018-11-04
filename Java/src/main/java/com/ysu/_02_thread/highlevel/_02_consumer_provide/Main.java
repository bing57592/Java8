package com.ysu._02_thread.highlevel._02_consumer_provide;


import com.ysu._00_common.util.MyThreadUtils;

/**
 * created by bing57592
 * 2018-11-04 13:01
 */
public class Main {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            while (true) {
                System.out.println(shareData.num);
                MyThreadUtils.sleep(1000);
            }
        }).start();

        MyThreadUtils.sleep(2000);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // shareData.insc();
                shareData.insc2();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // shareData.insc();
                shareData.insc2();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // shareData.desc();
                shareData.desc2();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // shareData.desc();
                shareData.desc2();
            }
        }).start();

    }
}
