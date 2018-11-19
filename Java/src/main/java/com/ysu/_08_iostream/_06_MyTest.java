package com.ysu._08_iostream;

import java.util.Stack;

/**
 * @Author bing57592
 * @Date 2018-11-13 19:12
 */
public class _06_MyTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(2345);
        System.out.println(stack.pop());

        Integer peek = stack.peek();

    }
}
