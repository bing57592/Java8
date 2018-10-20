/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._03_linkedlist;

import com.ysu.leetcode._01_primary._00_domain.ListNode;

/**
 * 反转一个单链表。
 * Created by 陈宪东 on 2018/8/27 16:04
 */
public class _03 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.setNext(node2.setNext(node3.setNext(node4)));
    }

    public static ListNode code_1(ListNode head) {
        return null;
    }
}
