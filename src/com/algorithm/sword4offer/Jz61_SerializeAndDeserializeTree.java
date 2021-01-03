package com.algorithm.sword4offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * <p>
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * <p>
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * {8,6,10,5,7,9,11}
 */
public class Jz61_SerializeAndDeserializeTree {
    //思路：本解法利用平序遍历，加上队列数据结构完成序列化与反序列化。

    String Serialize(TreeNode root) {
        if (root == null) return "#,!";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> rootQueue = new ArrayDeque<>();
        rootQueue.add(root);
        while (!rootQueue.isEmpty()) {
            TreeNode cursor = rootQueue.poll();
            if (cursor.val == Integer.MIN_VALUE) {
                sb.append("#,");
            } else {
                sb.append(cursor.val).append(",");
                if (cursor.left == null) {
                    rootQueue.add(new TreeNode(Integer.MIN_VALUE));
                } else {
                    rootQueue.add(cursor.left);
                }
                if (cursor.right == null) {
                    rootQueue.add(new TreeNode(Integer.MIN_VALUE));
                } else {
                    rootQueue.add(cursor.right);
                }
            }
        }
        sb.append("!");
        return sb.toString();
    }


    TreeNode Deserialize(String str) {
        String[] ch = str.split(",");
        int len = ch.length;
        if (ch[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(ch[0]));
        int childIndex = 1;
        TreeNode current;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (childIndex < len && !ch[childIndex].equals("!")) {
            current = queue.poll();
            if (!ch[childIndex].equals("#") && current != null) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(ch[childIndex]));
                current.left = leftNode;
                queue.add(leftNode);
            }
            childIndex++;
            if (!ch[childIndex].equals("#") && current != null) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(ch[childIndex]));
                current.right = rightNode;
                queue.add(rightNode);
            }
            childIndex++;
        }
        return root;
    }

    //补充 前序遍历结果
}
