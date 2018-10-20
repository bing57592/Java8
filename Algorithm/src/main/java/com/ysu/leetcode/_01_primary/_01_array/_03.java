package com.ysu.leetcode._01_primary._01_array;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class _03 {
    public static void main(String[] args) {


    }


    public static void code_1(int[] nums, int k) {
        int bufferArray[] = new int[k];
        k = k % nums.length;

        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            bufferArray[index++] = nums[i];
        }
        int temp = 0;
        for (int i = nums.length - k - 1; i >= 0; i--) {
            temp = nums[i];
            nums[i] = nums[i + k];
            nums[i + k] = temp;
        }// 把元素移过去
        for (int i = 0; i < bufferArray.length; i++) {
            nums[i] = bufferArray[i];
        }
    }

    public static void code(int[] nums, int k) {
        int newArr[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }
    }
}
