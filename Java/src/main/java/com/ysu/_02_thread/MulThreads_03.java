package com.ysu._02_thread;

import java.util.HashMap;
import java.util.Map;

/**
 * created by bing57592
 * 2018-10-23 22:14
 */
public class MulThreads_03 {
    private static Map<String, Object> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                map.put("1", null);
            });
        }
    }
}
