package com.ysu._00_common.bean;

/**
 * created by bing57592
 * 2018-10-19 13:05
 */
public class Person {
    public String name;
    private int age;

    public Person() {
        System.out.println("调用空参构造器");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("public void方法: name = " + this.name + "age = " + this.age);
    }

    public String info() {
        return name + ":" + age;
    }

    private void display(String nation) {
        System.out.println("private void方法: nation : " + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
