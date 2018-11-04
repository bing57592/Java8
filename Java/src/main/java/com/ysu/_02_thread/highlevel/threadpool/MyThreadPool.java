package com.ysu._02_thread.highlevel.threadpool;

import com.ysu._00_common.util.MyStringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by bing57592
 * 2018-11-04 18:13
 */
public class MyThreadPool {
    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
//        Map<String, Integer> map = new HashMap<>();
        ExecutorService service = Executors.newFixedThreadPool(100);


        for (int i = 0; i < 100; i++) {
            String str = String.valueOf(i);
            service.submit(() -> {
                // map.put(str, MyMathUtils.randomInt(1000));
                map.put(str, Integer.parseInt(str));
                MyStringUtils.println("线程 ? , map的key ?", new Object[]{Thread.currentThread().getName(), str});
            });
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            Integer integer = map.get(String.valueOf(i));
            sum += integer;
        }

        System.out.println(sum);
        service.shutdown();
    }
}
