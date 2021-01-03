package com.algorithm.sword4offer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * <p>
 * 示例1
 * 输入
 * [1,2,3,4,5],[4,3,5,1,2]
 * 返回值
 * false
 */
public class Jz21_IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> pushQueue = new ArrayDeque<>();
        for (int i = 0; i < pushA.length; i++) {
            pushQueue.add(pushA[i]);
        }
        for (int i = 0; i < popA.length; i++) {
            if (!pushQueue.isEmpty() && pushQueue.peek() == popA[i]) {
                pushQueue.poll();
            } else if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
            } else if ((!pushQueue.isEmpty() && pushQueue.peek() != popA[i])) {
                // always push to stack util find this
                while ((!pushQueue.isEmpty() && pushQueue.peek() != popA[i])) {
                    stack.push(pushQueue.poll());
                }
                if (pushQueue.isEmpty()) {
                    return false;
                } else {
                    pushQueue.poll();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 思路二： 新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length != pushA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 3, 5, 1, 2};
        System.out.println(new Jz21_IsPopOrder().IsPopOrder(pushA, popA));
    }
}
