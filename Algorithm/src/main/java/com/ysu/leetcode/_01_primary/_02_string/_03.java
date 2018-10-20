package com.ysu.leetcode._01_primary._02_string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * created by bing57592
 * 2018-08-03 23:14
 */
public class _03 {
    public static void main(String[] args) {
        String s1 = "dddccdbba";
        int i = code_1(s1);
        int i1 = code_2(s1);
        System.out.println(i1);
    }

    public static int code_1(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 0;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    break;
                } else {
                    if (j == chars.length - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static int code_2(String s) {
        char[] chars = s.toCharArray();
        char lables[] = new char[chars.length];
        int index = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);
            if (integer == null) {
                lables[index++] = chars[i];
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], ++integer);
            }
        }
        char flag = 0;
        for (int i = 0; i < index; i++) {
            if (map.get(lables[i]) == 1) {
                flag = lables[i];
                break;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == flag) {
                return i;
            }
        }

        return -1;
    }
}
