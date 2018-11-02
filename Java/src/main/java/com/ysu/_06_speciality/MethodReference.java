package com.ysu._06_speciality;

import com.ysu._00_common.util.MyStringUtils;
import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * Java8新特性 - 方法引用:
 * 1. 方法引用 就是Lambda表达式.
 * ****  Lambda表达式, 是函数式接口的实例.  方法引用, 也是函数式接口的实例.
 * 2. 使用的情景:
 * ****  当要传递给Lambda表达式的的操作, 已经有实现的方法了, 就可以使用方法引用.
 * 3. 要求:
 * ****  函数式接口中[抽象方法]的形参列表和返回值类型, 要与[方法引用对应的方法]的形参列表和返回值类型保持一致.
 * 4. 格式:  类或者对象::方法名
 * ****    类::静态方法 --- 1
 * ****  对象::实例方法 --- 2
 * ****  对象::实例方法 --- 3
 * created by bing57592
 * 2018-10-28 18:08
 */
public class MethodReference {


    @Test
    public void test1() throws Exception {
        Consumer<String> consumer1 = s -> System.out.println(s);
        consumer1.accept("Roushan 是不可战胜的!!!");
        MyStringUtils.line(); // 使用Lambda表达式.

        PrintStream out = System.out;
        Consumer<String> consumer2 = out::println;//一个函数式接口, 等于一个和它相同入参&返回值的方法.
        consumer2.accept("木已成舟");
        MyStringUtils.line();

        MyFunctionRef myFunctionRef = MethodReference::MyFunction;// 左边是方法的声明, 右边是方法声明的具体实现.
        String hello = myFunctionRef.myFunction("hello", 4);
        System.out.println(hello);
        MyStringUtils.line();
    }

    public static String MyFunction(String str1, Integer integer) {
        System.out.println(str1);
        System.out.println("现在是在MyFunction中");
        System.out.println(integer);
        return "Eureka";
    }
}

@FunctionalInterface
interface MyFunctionRef {
    String myFunction(String str1, Integer integer);
}

