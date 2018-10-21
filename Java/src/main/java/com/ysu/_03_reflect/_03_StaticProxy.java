package com.ysu._03_reflect;

import com.ysu._00_common.util.MyStringUtils;

/**
 * 静态代理: 代理模式, 策略模式
 * created by bing57592
 * 2018-10-21 10:17
 */
public class _03_StaticProxy {
    public static void main(String[] args) {
        StaticProxyFactory proxyFactory = new StaticProxyFactory(new PS4_Factory());
        proxyFactory.product();
        MyStringUtils.line();
        StaticProxyFactory lambdaFactory = new StaticProxyFactory(() -> System.out.println("LambdaFactory开始工作"));
        lambdaFactory.product();
    }
}

class StaticProxyFactory implements Factory {
    Factory factory;

    public StaticProxyFactory() {
    }

    public StaticProxyFactory(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void product() {
        System.out.println("代理工厂准备工作");
        factory.product();
        System.out.println("代理工厂收尾工作");
    }
}

interface Factory {
    void product();
}

class PS4_Factory implements Factory {
    @Override
    public void product() {
        System.out.println("生产PS4");
    }
}

class Switch_Factory implements Factory {

    @Override
    public void product() {
        System.out.println("生产 Switch");
    }
}


