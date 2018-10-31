/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.aop;

import com.ysu.utils.BeanUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * Created by 陈宪东 on 2018/10/25 17:37
 */
@Aspect
@Component
public class UserAop {

    public UserAop() {
        BeanUtils.declareInit(UserAop.class);
    }

    @Before("execution(* com.ysu.service.UserService.insert(..))")
    public void before() {
        System.out.println("[AOP] Before");
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
