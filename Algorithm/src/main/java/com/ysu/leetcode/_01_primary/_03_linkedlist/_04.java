/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._03_linkedlist;

import com.ysu.leetcode._01_primary._00_domain.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * Created by 陈宪东 on 2018/8/24 17:51
 */
public class _04 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);

//        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(2);
//        ListNode node6 = new ListNode(4);

//        node1.setNext(node2.setNext(node3));
//
//        node4.setNext(node5.setNext(node6));
        ListNode listNode = code_1(node1, null);

        System.out.println(listNode);

    }

    public static ListNode code_1(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {//l1 的值比l2 的值小.
                listNode.next = new ListNode(l1.val);
                listNode = listNode.next;
                l1 = l1.next;
            } else {//l1 的值比l2 的值大.
                listNode.next = new ListNode(l2.val);
                listNode = listNode.next;
                l2 = l2.next;
            }
        }// 当某一个链表被撸完之后. 另一个链表直接连过去.
        if (l1 == null) {// l1先被撸完了, 撸l2
            while (l2 != null) {
                listNode.next = new ListNode(l2.val);
                listNode = listNode.next;
                l2 = l2.next;
            }
        } else {// l2先被撸完了, 撸l1
            while (l1 != null) {
                listNode.next = new ListNode(l1.val);
                listNode = listNode.next;
                l1 = l1.next;
            }
        }

        return head.next;
    }
}
