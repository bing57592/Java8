/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._02_string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * "A man, a plan, a canal: Panama" ==> true
 * "race a car" ==> false
 * Created by 陈宪东 on 2018/8/6 17:26
 */
public class _05 {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean b = code_1(str);
        System.out.println(b);
    }

    public static boolean code_1(String s) {
        char[] chars = s.toCharArray();
        char[] charArray = new char[chars.length];
        int length = 0;
        for (char aChar : chars) {
            if (aChar >= 'A' && aChar <= 'Z') {//对于A~Z的情况, 转换为a~z的情况, 并存起来
                aChar = (char) (aChar + 32);
                charArray[length++] = aChar;
                continue;
            }
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= '0' && aChar <= '9')) {
                charArray[length++] = aChar;
                continue;
            }
        }
        if (length % 2 == 0) {//说明有偶数个
            for (int i = 0; i < length / 2; i++) {
                if (charArray[i] != charArray[length - 1 - i]) return false;
            }
        } else {//说明有奇数个
            for (int i = 0; i < length / 2; i++) {
                if (charArray[i] != charArray[length - 1 - i]) return false;
            }
        }
        return true;
    }
}
