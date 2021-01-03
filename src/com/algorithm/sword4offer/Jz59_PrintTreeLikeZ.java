package com.algorithm.sword4offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class Jz59_PrintTreeLikeZ {
    // 思路： 用两个栈进行辅助
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Stack<TreeNode> left2RightStack = new Stack<>();
        Stack<TreeNode> right2LeftStack = new Stack<>();

        left2RightStack.push(pRoot);
        while (!left2RightStack.isEmpty() || !right2LeftStack.isEmpty()){
            ArrayList<Integer> l2rList = new ArrayList<>();
            while (!left2RightStack.isEmpty()) {
                TreeNode top = left2RightStack.pop();
                l2rList.add(top.val);
                if (top.left != null) {
                    right2LeftStack.push(top.left);
                }
                if (top.right != null) {
                    right2LeftStack.push(top.right);
                }
            }
            if (!l2rList.isEmpty()) {
                res.add(l2rList);
            }
            ArrayList<Integer> r2lList = new ArrayList<>();
            while (!right2LeftStack.isEmpty()) {
                TreeNode top = right2LeftStack.pop();
                r2lList.add(top.val);
                if (top.right != null) {
                    left2RightStack.push(top.right);
                }
                if (top.left != null) {
                    left2RightStack.push(top.left);
                }
            }
            if (!r2lList.isEmpty()) {
                res.add(r2lList);
            }
        }
        return res;
    }
}
