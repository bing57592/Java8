package com.ysu._02_thread;

import com.ysu._00_common.util.MyThreadUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by bing57592
 * 2018-10-23 22:14
 */
public class MulThreads_03 {
    private static Map<String, Object> map = new HashMap<>();

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                MyThreadUtils.sleep(1);
                list.add(i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                MyThreadUtils.sleep(1);
                list.add(i);
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }


}
