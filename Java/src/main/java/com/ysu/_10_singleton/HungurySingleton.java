package com.ysu._10_singleton;

/**
 * created by bing57592
 * 2018-11-02 09:26
 */
public class HungurySingleton {
    private static final HungurySingleton mInstance = new HungurySingleton();

    private HungurySingleton() {

    }

    public static HungurySingleton getHunguryInstance() {
        return mInstance;
    }

}
