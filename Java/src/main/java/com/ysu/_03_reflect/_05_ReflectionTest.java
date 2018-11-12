package com.ysu._03_reflect;

import com.ysu._00_common.bean.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author bing57592
 * @Date 2018-11-08 22:43
 */
public class _05_ReflectionTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<? extends Person> claz = person.getClass();

        Method method = claz.getMethod("adfz");
        method.setAccessible(true);// 可理解的, 可见性.
        Object invoke = method.invoke(person);


        Field hello = claz.getField("hello");
        Object o = hello.get(person);
    }
}
