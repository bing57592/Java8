package com.ysu.leetcode._01_primary._06_dynamic;

/**
 * f(0) = array[0]
 * f(1) = max(array[0], array[1])
 * f(n) = max( f(n-2) + array[n], f(n-1) )
 * created by bing57592
 * 2018-08-30 18:49
 */
public class _03 {
    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 1};
    }

    //TODO: 这个, 是抄的答案. 需要背下来
    public static int function(int nums[]) {
        //sum[i]=max(sum[i-1],sum[i-2]+nums[i])
        //sum[0]=nums[0];
        //sum[1]=max(nums[0],nums[1]);
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
        }
        return sum[nums.length - 1];
    }
}
