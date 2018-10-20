package com.ysu.leetcode._01_primary._01_array;

import com.ysu.myutil.MyArrayUtil;
import com.ysu.myutil.MyStringUtil;
import org.junit.Test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * created by bing57592
 * 2018-08-02 23:02
 */
public class _08 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 5, 6, 7, 8, 10, 0, 12};
        // int[] result1 = moveZero_1(nums, 0, 0);

        //int[] result2 = moveZero_2(nums);

        int[] result3 = code_3(nums);
        MyArrayUtil.ergodicArray(result3);

    }

    public static void code_1(int nums[]) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {//表示当前元素为0, 则需要开始移动了

            }
        }
    }


    public static int[] code_3(int nums[]) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                int temp = nums[i];
                nums[i] = nums[i - zeroCount];
                nums[i - zeroCount] = temp;
            }
        }
        return nums;
    }


    public static int[] code_2(int nums[]) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {//这里有else
                zeroCount++;
                if (nums[i + 1] != 0) {
                    //交换nums[i + 1 - zeroCount] 和 nums[i+1]
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i + 1 - zeroCount];
                    nums[i + 1 - zeroCount] = temp;
                    i++;
                }
            } else {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i + 1 - zeroCount];
                nums[i + 1 - zeroCount] = temp;
            }
        }
        return nums;
    }

    public static int[] moveZero_1(int nums[], int zeroCount, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[startIndex + 1] == 0) {
                moveZero_1(nums, ++zeroCount, startIndex + 1);
            } else {//对 startIndex + 1 位置的元素和 startIndex + 1 - zeroCount的元素进行互换
                int temp = nums[startIndex + 1];
                nums[startIndex + 1] = nums[startIndex - zeroCount];
                nums[startIndex - zeroCount] = temp;
            }
        }
        return nums;
    }

    @Test
    public void test1() {
        int a = 5;
        int b = 10;
        swap(a, b);
        System.out.println(a + " & " + b);
        System.out.println(MyStringUtil.DEFAULT_LINEAE);
        int arrays[] = new int[]{1, 2};
        swap(arrays[0], arrays[1]);
        MyArrayUtil.ergodicArray(arrays);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
