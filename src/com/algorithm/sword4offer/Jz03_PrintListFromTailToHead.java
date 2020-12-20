package com.algorithm.sword4offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * <p>
 * 示例1
 * 输入
 * {67,0,24,58}
 * 返回值
 * [58,24,0,67]
 */
public class Jz03_PrintListFromTailToHead {
    // 利用栈的特性
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode index = listNode;
        ArrayList res = new ArrayList<Integer>();
        if (listNode == null) return res;
        Stack<Integer> tempStack = new Stack<Integer>();
        while (index != null) {
            tempStack.push(index.val);
            index = index.next;
        }
        while (!tempStack.empty()) {
            res.add(tempStack.pop());
        }
        return res;
    }

    //利用递归
    ArrayList<Integer> res  = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
