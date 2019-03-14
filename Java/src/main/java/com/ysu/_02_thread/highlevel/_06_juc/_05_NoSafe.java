package com.ysu._02_thread.highlevel._06_juc;

import com.ysu._00_common.util.MyThreadUtils;
import org.junit.Test;

import java.util.*;

/**
 * created by bing57592
 * 2018-11-04 21:46
 */
public class _05_NoSafe {

    /**
     * 分段锁 HashMap -> ConcurrentHashMap
     *
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            int flag = i;
            new Thread(() -> {
                map.put(String.valueOf(flag), String.valueOf(flag));
                System.out.println(map);
            }).start();
        }

    }

    /**
     * 写时复制技术 HashSet -> CopyOnWriteHashSet
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            int flag = i;
            new Thread(() -> {
                set.add(String.valueOf(flag));
                // 同下, 没有输出语句的时候, HashMap不会出现线程安全问题. 是为什么?
                System.out.println(set);
            }).start();
        }
    }

    /**
     * 写时复制技术  ArrayList -> CopyOnWriteArrayList
     *
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        List<String> list = new ArrayList<>();
        // 多线程 + 高并发

        try {
            for (int i = 0; i < 100; i++) {
                int flag = i;
                new Thread(() -> {
                    list.add(String.valueOf(flag));
                    // 为什么没有这句话, 就不会CME;
                    // System.out.println(list);
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MyThreadUtils.stopJVM(1);
        } finally {

        }

    }
}
