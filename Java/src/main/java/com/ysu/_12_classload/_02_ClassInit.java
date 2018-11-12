package com.ysu._12_classload;

/**
 * @Author bing57592
 * @Date 2018-11-09 11:21
 */
public class _02_ClassInit {
    static {
        i = 0;
        // 下面这句话, 会提示"非法向前引用"
        // System.out.println(i);
    }

    static int i = 0;
}
