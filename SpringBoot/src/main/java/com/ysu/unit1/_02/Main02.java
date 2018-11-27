package com.ysu.unit1._02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author bing57592
 * @Date 2018-11-27 13:36
 */
public class Main02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ioc // 将配置类放置容器中, 与之相对的是配置文件.
                = new AnnotationConfigApplicationContext(DiConfig.class);
        FunctionServiceUser bean = ioc.getBean(FunctionServiceUser.class);
        ioc.close();
    }

}
