package com.ysu._12_classload._01_override;

/**
 * @Author bing57592
 * @Date 2018-11-23 13:36
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();
        child.method();
        parent.method();
    }
}
