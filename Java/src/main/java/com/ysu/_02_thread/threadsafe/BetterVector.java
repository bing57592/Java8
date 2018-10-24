package com.ysu._02_thread.threadsafe;

import java.util.Vector;

/**
 * 扩展一个Vector, 并增加一个"若没有, 则添加" 的方法
 * created by bing57592
 * 2018-10-23 21:49
 */
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E e) {
        boolean absent = !contains(e);
        if (absent) add(e);
        return absent;
    }

}
