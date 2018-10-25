/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.util;

/**
 * Created by 陈宪东 on 2018/10/25 18:33
 */
public class BeanUtils {
    public static void declareInit(Class<?> clazz) {
        System.out.println(clazz.getName() + ": 调用构造方法");
    }
}
