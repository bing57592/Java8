package com.ysu.myutil;


import org.junit.Test;

public class MyArrayUtil {

    public static void ergodicArray(int[] nums) {
        System.out.print("{");
        for (int i = 0; i < nums.length; i++) {
            String str = ", ";
            if (i == nums.length - 1) str = "";

            System.out.print(nums[i] + str);

        }
        System.out.print("}");
        System.out.println();
    }


    @Test
    public void test1() {
        System.out.println(mul(5));
    }

    public int mul(int n) {
        if (n == 1) return 1;

        return n * mul(n - 1);
    }
}
