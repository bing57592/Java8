package com.ysu._01_jvm.classload;

/**
 * created by bing57592
 * 2019-02-11 22:25
 */
public class Exercise1 {
    public static void main(String[] args) {
        HelloB helloB = new HelloB();
    }

}

class HelloA {
    public HelloA() {
        System.out.println("Hello A");//4
    }

    static {
        System.out.println("static A");//1
    }

    {
        System.out.println("I am A");//3
    }
}

class HelloB extends HelloA {
    public HelloB() {
        System.out.println("Hello B");//6
    }

    static {
        System.out.println("static B");//2
    }

    {
        System.out.println("I am B");//5
    }
}
