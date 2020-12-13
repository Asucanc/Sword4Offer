package com.algorithm.sword4offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 1
 * 返回值
 * 1
 * <p>
 * 示例2
 * 输入
 * 4
 * 返回值
 * 5
 * <p>
 * 思路：
 * 记青蛙跳n阶台阶的跳法总数为F(n)
 * 则 转移方程  F(n) = F(n-1) + F(n-2)
 * <p>
 * F(1)=1, F(2)=2,  F(3)=3, F(4)=5, F(5)=8
 * 本题本质就是斐波拉契数列问题，可以用递归，但是递归的时候可能会造成栈的溢出，因为递归就是方法栈的堆叠。
 * 可以使用迭代来避免这个问题。
 */
public class Jz08_JumpSteps {
    // 递归版本
    public int jumpSteps(int target) {
        if (target > 0 && target <= 3) {
            return target;
        }
        return jumpSteps(target - 1) + jumpSteps(target - 2);
    }

    // 迭代版本
    public int jumpSteps1(int target) {
        int[] res = new int[target + 1];
        if (target >= 0 && target <= 3) {
            return target;
        }
        for (int i = 0; i <= 3; i++) {
            res[i] = i;
        }
        for (int i = 4; i <= target; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target];
    }

    public static void main(String[] args) {
        System.out.println(new Jz08_JumpSteps().jumpSteps1(1));
    }
}
