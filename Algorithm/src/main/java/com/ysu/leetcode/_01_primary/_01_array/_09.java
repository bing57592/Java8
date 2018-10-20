package com.ysu.leetcode._01_primary._01_array;

import com.ysu.myutil.MyArrayUtil;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * created by bing57592
 * 2018-08-02 23:57
 */
public class _09 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = code_1(nums, target);
        MyArrayUtil.ergodicArray(ints);
    }

    public static int[] code_1(int[] nums, int target) {
        int ints[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }

        return nums;
    }
}
