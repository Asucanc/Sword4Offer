package com.algorithm.sword4offer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：构造一个minStack就行了，难点是题目描述不清楚，题意是通过构造一个特殊的数据结构能够一直保存当前栈中的最小值
 */
public class Jz20_MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (!minStack.isEmpty() && minStack.peek() < node) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
