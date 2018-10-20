package com.ysu.leetcode._01_primary._01_array;

import com.ysu.myutil.MyStringUtil;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class _02 {
    public static void main(String[] args) {
        int price[] = new int[]{7, 1, 5, 3, 6, 4};
        code_2(price);
    }

    public static void code_1(int[] prices) {
        int flag = 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                // 此时索引'i', 对应的是一个低点
                flag = i + 1;//flag是低点的下一个元素
                while (prices[flag] < prices[flag + 1] && flag < prices.length - 1) {//说明随后还有更贵的价格
                    flag++;
                }//跳出循环后, flag就是最高价格
                profit += prices[flag] - prices[i];
                i = flag - 1;
            }
        }
        System.out.println("总共盈利: " + profit);
        System.out.println(MyStringUtil.DEFAULT_LINEAE);
    }

    public static void code_2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        System.out.println("总共盈利: " + profit);
    }
}
