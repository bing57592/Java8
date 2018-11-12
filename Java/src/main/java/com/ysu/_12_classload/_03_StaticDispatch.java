package com.ysu._12_classload;

/**
 * 方法静态分派演示
 *
 * @Author bing57592
 * @Date 2018-11-09 18:33
 */
public class _03_StaticDispatch {
    static abstract class Human {

    }

    static class Man extends Human {
    }

    static class Woman extends Human {

    }

    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello gentleman!"); // 1  1
    }

    public void sayHello(Woman guy) {
        System.out.println("hello lady!");// 2  2
    }

    public static void main(String[] args) {
        Man man = new Man();
        Woman woman = new Woman();
        _03_StaticDispatch sr = new _03_StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

}
