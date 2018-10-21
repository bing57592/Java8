package com.ysu._03_reflect;

import com.ysu._00_common.util.MyStringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 要想实现动态代理类对象的功能，需要解决两个问题：
 * ①如何根据加载到内存中的被代理类对象，动态的去创建代理类的对象
 * ②如何通过代理类的对象调用接口中声明的方法时，实现对被代理类对象同名方法的调用
 * <p>
 * 其实还是没懂...
 * <p>
 * created by bing57592
 * 2018-10-21 10:48
 */
public class _04_DynamicProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxySuperMan = (Human) DynamicProxyFactory.getProxyInstance(superMan);
        proxySuperMan.say();
        proxySuperMan.fly();

        MyStringUtils.line();

        Switch_Factory switch_factory = new Switch_Factory();
        Factory proxyInstance = (Factory)DynamicProxyFactory.getProxyInstance(switch_factory);
        proxyInstance.product();
    }
}


class MyInvocationHandler implements InvocationHandler {
    private Object object; //看做被代理类的对象

    //解决上述说明的问题②
    //当通过代理类的对象调用接口中的方法a时，就会调用如下的InvocationHandler中的invoke()
    //这里希望调用的是被代理类方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invokeVal = method.invoke(object, args);
        return invokeVal;
    }

    public void bind(Object object) {
        this.object = object;
    }

}

class DynamicProxyFactory {
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj) {//形参obj：被代理类的对象

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        // 下边这个方法, 入参分别为: 1.与代理类相同的类加载器, 2.与代理类相同的接口, 3.被代理类的对象
        // 返回一个代理类的对象.
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

interface Human {
    void say();

    void fly();
}

class SuperMan implements Human {

    @Override
    public void say() {
        System.out.println("超人say");
    }

    @Override
    public void fly() {
        System.out.println("超人fly");
    }
}