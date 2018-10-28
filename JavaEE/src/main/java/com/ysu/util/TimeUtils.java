package com.ysu.util;

/**
 * created by bing57592
 * 2018-10-28 15:19
 */
public class TimeUtils {

    /**
     * 使线程休眠一段时间, 单位毫秒
     *
     * @param milliSeconds 休眠时间, 单位毫秒
     */
    public static void milSecondsArea(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
            System.out.print("线程休眠:\t" + milliSeconds + "毫秒\t");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
