package com.algorithm.sword4offer;

import java.util.HashMap;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Jz25_RandomListNodeClone {
    // 思路：建立一个map，第一次遍历，存下旧的节点和新new的节点的映射关系。
    // 第二次遍历建立新节点的next和random，两者都是从map从获取的new出来的节点
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> listNodeHashMap = new HashMap();
        RandomListNode cursor = pHead;
        while (cursor != null) {
            listNodeHashMap.put(cursor, new RandomListNode(cursor.label));
            cursor = cursor.next;
        }
        cursor = pHead;
        while (cursor != null) {
            RandomListNode newNode = listNodeHashMap.get(cursor);
            newNode.next = listNodeHashMap.get(cursor.next);
            newNode.random = listNodeHashMap.get(cursor.random);
            cursor = cursor.next;
        }
        return listNodeHashMap.get(pHead);
    }
}
