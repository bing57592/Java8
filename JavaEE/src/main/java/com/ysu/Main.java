/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu;

/**
 * Created by 陈宪东 on 2018/12/3 18:11
 */
public class Main {
    public static void main(String[] args) {
        DemoEnum demoEnum;
        System.out.println("声明变量后, 是否调用");

        DemoEnum demoEnum1 = DemoEnum.QUARTER;
        System.out.println("调用类的属性后, 是否调用");
    }
}
