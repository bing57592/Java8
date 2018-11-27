/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.test;

import com.ysu.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:springmvc.xml"});

        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");

        System.out.println(demoService.HelloWorld("哈哈哈"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
