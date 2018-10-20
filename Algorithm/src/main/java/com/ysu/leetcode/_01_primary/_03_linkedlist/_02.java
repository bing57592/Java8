/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._03_linkedlist;

import com.ysu.leetcode._01_primary._00_domain.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * Created by 陈宪东 on 2018/8/15 16:33
 */
public class _02 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        System.out.println(amount(node1));

        node1.setNext(node2.setNext(node3.setNext(node4.setNext(node5))));
        ListNode listNode = code_1(node1, 2);
        System.out.println(listNode);

    }

    /**
     * 给定一个链表, 算出链表的总长度
     *
     * @param head
     * @return
     */
    public static int amount(ListNode head) {
        if (head == null) return 0;

        int i = 1;
        while (head.next != null) {
            i++;
            head = head.next;
        }
        return i;
    }


    public static ListNode code_1(ListNode head, int n) {
        int amount = amount(head);
        int index = amount + 1 - n;// 根据倒数第几个节点, 算出正数第几个节点

        ListNode now = head;

        // 已经实现: 正数第N个节点的删除操作
        int i = 1;
        if (index == 1) {
            return now.next;
        }
        while (now.next != null) {
            if (i + 1 == index) {//在i == index 的时候, next就需要被删除掉了.
                now.next = now.next.next;
                return head;
            }
            now = now.next;
            i++;
        }

        return head;
    }

    public static ListNode code_2(ListNode head, int n) {

        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && n > -1) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
