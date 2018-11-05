package com.ysu._02_thread.highlevel._07_SingleInstance;

/**
 * @Author bing57592
 * @Date 2018-11-05 20:01
 */
public class Singleton_InnerClass {

    private Singleton_InnerClass() {}

    private static class SingletonInstance {
        private static final Singleton_InnerClass INSTANCE = new Singleton_InnerClass();
    }

    public static Singleton_InnerClass getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
