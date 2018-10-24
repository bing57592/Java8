package com.ysu._05_threadlocal;

import org.junit.Test;

/**
 * created by bing57592
 * 2018-10-21 20:11
 */
public class TestThreadLocal {
    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Test
    public void test() throws Exception{
    }

    public void insc(){
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {

            }).start();
        }
    }
}

class Instance{
    public ThreadLocal<Integer> threadLocal =  new ThreadLocal<>();

}
