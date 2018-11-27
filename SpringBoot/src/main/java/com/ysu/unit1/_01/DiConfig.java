package com.ysu.unit1._01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author bing57592
 * @Date 2018-11-27 13:21
 */
@Configuration // 声明这是一个配置类
@ComponentScan("com.ysu.unit1") // 声明自动扫描报下所有使用@Service, @Component, @Repository, @Controller
public class DiConfig {
    public DiConfig() {
        System.out.println("初始化");
    }
}
