/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._05_sortandserch;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * Created by 陈宪东 on 2018/8/27 18:12
 */
public class _01 {
    public static void main(String[] args) {

    }

    public static void code_1(int[] nums1, int m, int[] nums2, int n) {
        int sum[] = new int[m + n];
        int index = 0;
        int index1 = 0, index2 = 0;
        while (index1 < m && index2 < n) {// 在这里, 两个数组都没有撸完
            if (nums1[index1] <= nums2[index2]) {
                sum[index++] = nums1[index1++];
            } else {
                sum[index++] = nums2[index2++];
            }
        }
        if (index1 == m) {// 说明nums1撸完了
            for (int i = index2; i < n; i++) {
                sum[index++] = nums2[i];
            }
        }
        if (index2 == n) {// 说明nums2撸完了
            for (int i = index1; i < m; i++) {
                sum[index++] = nums1[i];
            }
        }
        for (int i = 0; i < sum.length; i++) {// 组装数据
            nums1[i] = sum[i];
        }
    }
}
