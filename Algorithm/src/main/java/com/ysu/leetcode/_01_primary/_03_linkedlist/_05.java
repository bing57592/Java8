/**
 * Copyright (c) 2015, www.jd.com. All rights reserved.
 * <p/>
 * 警告：本计算机程序受著作权法和国际公约的保护，未经授权擅自复制或散布本程序的部分或全部、以及其他
 * 任何侵害著作权人权益的行为，将承受严厉的民事和刑事处罚，对已知的违反者将给予法律范围内的全面制裁。
 */
package com.ysu.leetcode._01_primary._03_linkedlist;

import com.ysu.leetcode._01_primary._00_domain.ListNode;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * Created by 陈宪东 on 2018/8/27 14:52
 */
public class _05 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.setNext(node2.setNext(node3.setNext(node4)));

        boolean b = code_1(node1);
        System.out.println(b);
    }

    /**
     * 想到了用"栈"结构里做. 但是思路还是有点跑偏, 下次就能记住了.
     *
     * @param head
     * @return
     */
    public static boolean code_1(ListNode head) {
        ListNode now = head;

        Stack<ListNode> stack = new Stack<ListNode>();
        while (now != null) {
            stack.push(now);
            now = now.next;
        }

        while (head != null) {
            ListNode pop = stack.pop();
            if (pop.val != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
