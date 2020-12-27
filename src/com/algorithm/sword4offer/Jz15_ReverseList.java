package com.algorithm.sword4offer;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 示例1
 * 输入
 * {1,2,3}
 * 返回值
 * {3,2,1}
 */
public class Jz15_ReverseList {
    // No.1, 迭代反转链表，设置3个指针，start，mid，end。将mid的指针指向start，结束条件为mid到达原链表尾部，即end为null。
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = null, mid = head, end = head.next;
        while (end != null) {
            mid.next = start;
            start = mid;
            mid = end;
            end = end.next;
        }
        mid.next = start;
        return mid;
    }

    //No.2, 利用递归实现，从尾部开始一个一个指向前一个节点。
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNext = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNext;
    }

    //No.3, 头插法，开辟一个新的链表，每次从原来链表删除一个节点插入到新链表的头部。

    //No.4, 就地反转法，不需要开辟新的空间
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head, end = head.next;
        while (end != null) {
            start.next = end.next;
            end.next = head;
            head = end;
            end = start.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        printListNode(new Jz15_ReverseList().ReverseList2(head));
    }

    private static void printListNode(ListNode head) {
        ListNode cursor = head;
        while (cursor != null) {
            System.out.print(cursor.val + " -> ");
            cursor = cursor.next;
        }
    }
}
