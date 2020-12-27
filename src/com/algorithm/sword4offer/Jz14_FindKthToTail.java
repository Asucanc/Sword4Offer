package com.algorithm.sword4offer;


import java.util.List;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * 1,{1,2,3,4,5}
 * 返回值
 * {5}
 */
public class Jz14_FindKthToTail {
    // 思路： 创建两个快慢指针，gap为k-1,当快指针到达尾部，慢指针即为结果。
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return null;
        }
        ListNode fast = head, slow = head;
        int steps = 0;
        while (true) {
            if (steps < k - 1) {
                if (fast.next != null) {
                    fast = fast.next;
                    steps++;
                } else {
                    return null;
                }
            } else {
                if (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                } else {
                    return slow;
                }
            }
        }
    }

}
