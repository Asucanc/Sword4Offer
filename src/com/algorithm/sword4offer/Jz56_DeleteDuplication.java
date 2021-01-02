package com.algorithm.sword4offer;

import sun.jvm.hotspot.memory.LinearAllocBlock;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 示例1
 * 输入
 * {1,2,3,3,4,4,5}
 * 返回值
 * {1,2,5}
 *
 * 输入
 * {1,1,2,2,3,3,4,4,5}
 * 返回值
 * {5}
 */
public class Jz56_DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head, cursor = head.next;
        while (cursor != null) {
           if (cursor.next != null && cursor.next.val == cursor.val) {
               while (cursor.next != null && cursor.next.val == cursor.val) {
                   cursor = cursor.next;
               }
               cursor = cursor.next;
               pre.next = cursor;
           } else {
               pre = cursor;
               cursor = cursor.next;
           }
        }
        // 前面已经把重复的元素删除掉了，所有的构建关系已经完后，
        // 并且head的下一个元素一定是非重复的节点，也就是新的头节点
        return head.next;
    }
}
