package com.ysu._03_reflect.bean;


/**
 * created by bing57592
 * 2018-10-21 01:44
 */


@MyAnnotation(value = "ysu")
public class Person extends Creature<String> implements Comparable<Person>, MyInterface {

    public String name;
    private int age;

    private static String nation = "CHN";

    public Person() {
        System.out.println("Person()");
    }

    private Person(String name) {
        this.name = name;
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation(value = "hello")
    public void show() throws RuntimeException {
        System.out.println("name = " + name + ",age = " + age);
    }

    public String info() {
        return name + ":" + age;
    }

    private String display(String nation) {
        System.out.println("我是" + nation + "国家的人");
        return nation;
    }

    @Override
    @MyAnnotation(value = "hi")
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public static void showNation() {
        System.out.println("我是中国人！");
    }
}
