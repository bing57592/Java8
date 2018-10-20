/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._02_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 输入: s = "anagram", t = "nagaram" ==> true
 * 输入: s = "rat", t = "car" ==> false
 * <p>
 * PS:字母异位词-每个字母的数量相同, 但顺序不同
 * Created by 陈宪东 on 2018/8/6 17:08
 */
public class _04 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean b = code_2(s, t);
        System.out.println(b);
    }

    public static boolean code_2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) return false;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char sChar : sChars) {
            Integer integer = map.get(sChar);
            if (integer == null) {
                map.put(sChar, 1);
            } else {
                map.put(sChar, ++integer);
            }
        }

        for (char tChar : tChars) {
            Integer integer = map.get(tChar);
            if (integer == null) {
                return false;
            } else {
                map.put(tChar, --integer);
            }
            if (integer < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean code_1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) return false;

        int count = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) count++;

            if (count > 1) return false;
        }
        if (count == 1) return true;

        return false;
    }
}
