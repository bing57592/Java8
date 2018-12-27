package com.ysu.leetcode._01_primary._01_array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class _01 {
    public static void main(String[] args) {
        int i = code_1(new int[]{123, 245});
        System.out.println(i);
    }

    public static int code_1(int[] nums) {
        int countFlag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {

            } else {
                nums[i] = nums[i + 1];
                countFlag++;
            }
        }
        return nums.length - countFlag;
    }

    public static int code_2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
