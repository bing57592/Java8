package com.ysu._03_reflect._00_bean;

import java.io.Serializable;

/**
 * created by bing57592
 * 2018-10-21 01:43
 */
public class Creature<T> implements Serializable {

    public boolean gender;
    double weight;

    public void play(T t){
        System.out.println("Creature");
    }

}
