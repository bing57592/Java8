/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.aop;

import com.ysu.annotation.AntiBrush;
import com.ysu.util.BeanUtils;
import jdk.nashorn.internal.ir.BlockLexicalContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * Created by 陈宪东 on 2018/10/25 17:37
 */
@Aspect
@Component
public class UserAop {
    boolean flag = true;

    public UserAop() {
    }

    @Pointcut("@annotation(com.ysu.annotation.AntiBrush)")
    public void antiBrushAOP() {

    }

    @Around("antiBrushAOP()")// 每一个加了这个注解的方法, 都会走下面的逻辑. 如果调用了joinPont.proceed()方法, 就会执行被这个注解声明了的方法.
    public Object before(ProceedingJoinPoint joinPoint) throws Exception {
        Object obj = null;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        AntiBrush annotation = method.getAnnotation(AntiBrush.class);
        int counts = annotation.counts();
        int milliseconds = annotation.milliseconds();
        System.out.println("antiBrushAOP - " + counts + ":" + milliseconds);
        try {
            obj = joinPoint.proceed(); // 这个方法可以传一个Object[] 数组, 如果传了的话, 必须和目标方法入参相同. 如果不传就没有类似的规定.
            System.out.println("执行!!!!!!!!!! Let's Go! For the Horde");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

    @After("execution(* com.ysu.service.impl.UserServiceImpl.insert())")
    public void after() {
        System.out.println("[AOP] After");
    }


    @AfterReturning("execution(* com.ysu.service.impl.UserServiceImpl.insert(..))")
    public void afterReturning() {
        System.out.println("[AOP] AfterReturning");
    }

    @AfterThrowing("execution(* com.ysu.service.impl.UserServiceImpl.insert())")
    public void afterThrowing() {
        System.out.println("[AOP] AfterThrowing");
    }


}
