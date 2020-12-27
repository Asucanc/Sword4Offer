package com.algorithm.sword4offer;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Jz36_FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cursor1 = pHead1;
        ListNode cursor2 = pHead2;
        while (cursor1 != cursor2) {
            cursor1 = cursor1 != null ? cursor1.next : pHead2;
            cursor2 = cursor2 != null ? cursor2.next : pHead1;
        }
        return cursor1;
    }
}
