/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.unit2._01;

import com.ysu.unit2.DiConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by 陈宪东 on 2018/11/27 18:11
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ioc // 将配置类放置容器中, 与之相对的是配置文件.
                = new AnnotationConfigApplicationContext(DiConfig.class);
        BeanSingleton bean1 = ioc.getBean(BeanSingleton.class);
        BeanSingleton bean2 = ioc.getBean(BeanSingleton.class);
        System.out.println(bean1 == bean2);

        BeanPrototype bean3 = ioc.getBean(BeanPrototype.class);
        BeanPrototype bean4 = ioc.getBean(BeanPrototype.class);
        System.out.println(bean3 == bean4);
        //-------------------



    }
}
