package com.algorithm.sword4offer;

import java.util.HashSet;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Jz55_EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode cursor = pHead;
        while (cursor != null) {
            if (listNodes.contains(cursor)) {
                return cursor;
            } else {
                listNodes.add(cursor);
                cursor = cursor.next;
            }
        }
        return null;
    }
}
