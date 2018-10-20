package com.ysu.leetcode._01_primary._01_array;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class _07 {
    public static void main(String[] args) {

    }

    public static int[] code_1(int[] digits) {
        boolean needForward = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                needForward = false;
                break;
            }
        }
        if (needForward) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
        int index = digits.length - 1;
        while (digits[index] == 9) {
            digits[index--] = 0;
        }
        digits[index] = digits[index] + 1;
        return digits;
    }
}
