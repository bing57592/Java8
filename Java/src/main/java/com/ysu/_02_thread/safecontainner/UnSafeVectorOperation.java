package com.ysu._02_thread.safecontainner;

import java.util.Vector;

/**
 * created by bing57592
 * 2018-10-24 19:04
 */
public class UnSafeVectorOperation {
    public synchronized static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public synchronized static Object deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.remove(lastIndex);
    }


    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> UnSafeVectorOperation.deleteLast(integers)).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> UnSafeVectorOperation.getLast(integers)).start();
        }


    }
}
