package com.ysu._00_common.util;

/**
 * created by bing57592
 * 2018-11-04 12:52
 */
public class MyMathUtils {

    /**
     * 生成一个随机int数, [min, max)
     */
    public static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    /**
     * 生成一个随机int数, [0, max)
     */
    public static int randomInt(int max) {
        return randomInt(0, max);
    }

    public static long randomLong(long max) {
        return (long) (Math.random() * max) + 1;
    }

}
