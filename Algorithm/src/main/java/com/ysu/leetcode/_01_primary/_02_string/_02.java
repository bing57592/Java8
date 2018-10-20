package com.ysu.leetcode._01_primary._02_string;


/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * created by bing57592
 * 2018-08-03 22:19
 */
public class _02 {
    public static void main(String[] args) {
        int i = -123;
        int result = code_2(i);
        System.out.println(result);
    }

    public static int code_2(int x) {

        if (x >= 0) {
            int nums[];
            long sum = 0;
            nums = new int[(x + "").length()];
            int index = nums.length - 1;
            while (x != 0) {
                nums[index--] = x % 10;
                x = x / 10;
            }
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] * Math.pow(10, i);
            }
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
                return 0;

            return (int) sum;
        } else {
            int nums[];
            long sum = 0;
            nums = new int[(x + "").length() - 1];
            int index = nums.length - 1;
            while (x != 0) {
                nums[index--] = x % 10;//对负数取余的结果就是负数
                x = x / 10;
            }
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i] * Math.pow(10, i);
            }
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
                return 0;

            return (int) sum;
        }
    }

    public static int code_1(int x) {
        try {
            if (x < 0) {
                String s = -x + "";
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length / 2; i++) {
                    char temp = chars[i];
                    chars[i] = chars[chars.length - 1 - i];
                    chars[chars.length - 1 - i] = temp;
                }
                String str = "-" + new String(chars);
                return Integer.parseInt(str);
            } else {
                String s = x + "";
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length / 2; i++) {
                    char temp = chars[i];
                    chars[i] = chars[chars.length - 1 - i];
                    chars[chars.length - 1 - i] = temp;
                }
                String str = new String(chars);
                return Integer.parseInt(str);
            }// 这种算法题. 用String转数字是行不通的...
        } catch (Exception e) {
            return 0;
        }
    }
}
