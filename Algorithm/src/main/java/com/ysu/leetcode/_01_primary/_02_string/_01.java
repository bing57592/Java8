package com.ysu.leetcode._01_primary._02_string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * created by bing57592
 * 2018-08-03 22:09
 */
public class _01 {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = code_2(s);
        System.out.println(s1);
    }

    public static String code_1(String s) {
        String str = "";
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            str += chars[i];
        }
        return str;
    }// 果然超时了

    public static String code_2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        String str = new String(chars);
        return str;
    }

}
