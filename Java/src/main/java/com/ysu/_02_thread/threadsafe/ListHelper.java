package com.ysu._02_thread.threadsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * created by bing57592
 * 2018-10-23 22:00
 */
public class ListHelper<T> {
    public List<T> list = Collections.synchronizedList(new ArrayList<>());

    /**
     * 线程不安全的 "若没有, 则添加".
     *
     * @param t
     * @return
     */
    public synchronized boolean putIfAbsent_unsafe(T t) {
        boolean absent = !list.contains(t); //absent: 缺乏的
        if (absent) list.add(t);
        return absent;
    }

    /**
     * 线程安全的 "若没有, 则添加".
     *
     * @param t
     * @return
     */
    public boolean putIfAbsent_safe(T t) {
        synchronized (list) {
            boolean absent = !list.contains(t);
            if (absent) list.add(t);
            return absent;
        }
    }
}
