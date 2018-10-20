/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._03_linkedlist;

import com.ysu.leetcode._01_primary._00_domain.ListNode;

/**
 * Created by 陈宪东 on 2018/8/27 15:56
 */
public class _06 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(12);

        node1.setNext(node2.setNext(node3.setNext(node4.setNext(node5.setNext(node3)))));

        boolean b = code_1(node1);
        System.out.println(b);


    }

    public static boolean code_1(ListNode head) {
        //快慢指针
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
