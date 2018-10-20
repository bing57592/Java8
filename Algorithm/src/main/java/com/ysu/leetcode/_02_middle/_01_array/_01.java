package com.ysu.leetcode._02_middle._01_array;

import java.util.List;
import java.util.concurrent.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * created by bing57592
 * 2018-08-31 15:43
 */
public class _01 {


    public static List<List<Integer>> code_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];// 三个数中第一个数已经固定下来了
            // 需要遍历第二个数和第三个数的所有和的可能性, 找出 b + c = -a ;
            for (int j = i + 1; j < nums.length; j++) {// 从 a 的下一位

            }
        }

        return null;
    }
}
