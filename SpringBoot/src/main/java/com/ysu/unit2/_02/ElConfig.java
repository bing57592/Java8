/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.unit2._02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * Created by 陈宪东 on 2018/11/27 18:21
 */
@Configuration
@ComponentScan("com.ysu.unit2")
public class ElConfig {
    @Value("normal")
    public String normal;

    @Value("#{ systemProperties['os.name'] }")
    public String osName;

    @Value("#{ T(java.lang.Math).random() * 100 }")
    public double randomNumber;

    @Value("#{ beanEL.author }")
    public String fromAuthor;

    @Value("classpath:text.txt")
    public Resource testFile;

    @Value("http://www.baidu.com")
    public Resource testUrl;

    @Value("${book.name}")
    public String bookName;
}
