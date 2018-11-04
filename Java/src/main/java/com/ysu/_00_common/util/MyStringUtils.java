package com.ysu._00_common.util;

import org.junit.Test;

/**
 * created by bing57592
 * 2018-10-21 10:41
 */
public class MyStringUtils {
    /**
     * 分界符
     */
    public static void line() {
        System.out.println("--------------------");
    }


    public static String randomString(int length) {
        char[] chars = new char[length];
        for (char aChar : chars) {

        }
        return null;
    }

    public static void print(Object msg) {
        System.out.print(msg);
    }


    public static void println(Object msg) {
        msg += "\n";
        print(msg);
    }

    public static void println(String msg, Object... params) {
        msg += "\n";
        print(msg, params);
    }


    public static void print(String msg, Object... params) {

        String knife = "\\?";
        String result = "";

        // 这里: {} 以及 ? 属于特殊符号, 需要转义


        String[] split = msg.split(knife);
        for (int i = 0; i < params.length; i++) {
            result += split[i] + params[i];
        }
        if (split.length > params.length) {// 这里适配了结尾处为?的情况.
            result = result + split[split.length - 1];
        }
        System.out.print(result);
    }

    @Test
    public void test() throws Exception {
        String[] split = "当前线程 = ?   当前结果 = ?".split("\\?");
        System.out.println(split.length);
    }

}
