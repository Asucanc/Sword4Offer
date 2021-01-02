package com.algorithm.sword4offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 示例1
 * 输入
 * {5,4,#,3,#,2,#,1}
 * 返回值
 * [5,4,3,2,1]
 */
public class Jz22_PrintFromTopToBottom {
    // 思路： 用队列存下根节点，从队列头部取出一个元素执行作为临时根节点，拿到其值，然后将其左右节点放入队列尾部。直到队列为空
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> rootQueue = new ArrayDeque<>();
        rootQueue.add(root);
        while (!rootQueue.isEmpty()) {
            TreeNode cursor = rootQueue.poll();
            list.add(cursor.val);
            if (cursor.left != null) {
                rootQueue.add(cursor.left);
            }
            if (cursor.right != null) {
                rootQueue.add(cursor.right);
            }
        }
        return list;
    }
}
