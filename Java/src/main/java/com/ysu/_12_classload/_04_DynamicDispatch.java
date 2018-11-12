package com.ysu._12_classload;

/**
 * 方法动态分派演示
 *
 * @Author bing57592
 * @Date 2018-11-09 20:29
 */
public class _04_DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();// man
        woman.sayHello();// woman
        man = new Woman();
        man.sayHello();// woman
    }
}
