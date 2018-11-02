package com.ysu._10_singleton;

/**
 * created by bing57592
 * 2018-11-02 09:35
 */
public class LazySingleton {

    private static LazySingleton mInstance;

    private LazySingleton() {

    }

    public static LazySingleton getmInstance() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

}
