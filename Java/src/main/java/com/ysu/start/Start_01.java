package com.ysu.start;

import com.ysu.bean.Person;

/**
 * created by bing57592
 * 2018-10-19 13:06
 */
public class Start_01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAccount("23");
        person.setLevel("123");
        person.setPassword("21");
        System.out.println(person);
    }
}
