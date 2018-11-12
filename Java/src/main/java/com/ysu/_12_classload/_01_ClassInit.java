package com.ysu._12_classload;

/**
 * @Author bing57592
 * @Date 2018-11-08 23:01
 */
public class _01_ClassInit {
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }
}

