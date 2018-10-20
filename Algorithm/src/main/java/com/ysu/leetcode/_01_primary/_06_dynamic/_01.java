package com.ysu.leetcode._01_primary._06_dynamic;

import com.ysu.myutil.MyStringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 详情请看: https://www.sohu.com/a/153858619_466939
 * created by bing57592
 * 2018-08-28 10:58
 */
public class _01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // int function = function(48 , null);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int function = function(48);
        System.out.println(function);
        long end = System.currentTimeMillis();
        MyStringUtil.timeUsed(end - start);
    }

    public static int function(int n) {
        if (n == 1) return 1;

        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int temp = 0;

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                temp = b;
                b = a + b;
                a = temp;
            }
            return b;
        }
        return 0;
    }
}
