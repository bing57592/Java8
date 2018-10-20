/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._04_tree;

import com.ysu.leetcode._01_primary._00_domain.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * Created by 陈宪东 on 2018/8/27 16:50
 */
public class _01 {
    public static void main(String[] args) {
    }

    public static int maxDepth(TreeNode root) {
        // write your code here
        int height = 0;
        int Left = 0, Right = 0;
        if (root != null) {
            Left = maxDepth(root.left) + 1;
            Right = maxDepth(root.right) + 1;
        }
        if (Left > Right) {
            height = Left;
        } else height = Right;
        return height;
    }

    /**
     * 递归阶乘
     *
     * @param n
     * @return
     */
    public static long mul(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * mul(n - 1);
        }
    }

    /**
     * 递归求和
     *
     * @param n
     * @return
     */
    public static long sum(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + sum(n - 1);
        }
    }

}