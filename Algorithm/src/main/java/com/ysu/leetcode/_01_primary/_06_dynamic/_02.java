package com.ysu.leetcode._01_primary._06_dynamic;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 *
 * TODO: 和之前的不一样. 暂时没时间去想.
 * created by bing57592
 * 2018-08-30 09:44
 */
public class _02 {
    public static void main(String[] args) {
        int price[] = new int[]{7, 1, 5, 3, 6, 4};
        int i = code_1(price);
        System.out.println(i);
    }

    public static int code_1(int price[]) {
        int now = 0;
        int amount = 0;
        for (int i = 0; i < price.length - 1; i++) {
            if (now <= price[i + 1]) {
                amount += price[i + 1] - now;
                now = price[i];
            }
        }
        return amount;
    }
}

