/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._02_string;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * Created by 陈宪东 on 2018/8/7 20:49
 */
public class _07 {
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        int i = code_1(haystack, needle);
        System.out.println(i);
    }

    public static int code_1(String haystack, String needle) {
        if (needle == "") return 0;
        if (haystack.length() < needle.length()) return -1;
        int p;
        for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
            if (haystack.substring(i, needle.length()) == needle)
                return i;
        }
        return -1;
    }
}
