package com.ysu.bean;

/**
 * @Author bing57592
 * @Date 2018-11-07 21:51
 */
public class Person extends User  implements Runnable{
    private String name;
    int age;
    User user ;

    public Person() {
    }


    public void method1() {

    }

    private User method2() {
        return null;
    }



    public Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.method1();
    }
}
