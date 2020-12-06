package com.algorithm.sword4offer;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述:
 * 输出答案。
 * <p>
 * 示例1
 * 输入
 * 8
 * 返回值
 * 18
 * <p>
 * 思路：最值型，划分型 动态规划
 * 一段绳子你总能找到一个点将绳子分为两段，每一段都构成最小子问题。
 * 假设F[i]为长度为i的最大乘积，那么转移公式为 F[i] = F[j] * F[i-j]
 * F[1] = 1
 * F[2] = 2
 */
public class Jz67_CutRope {
    /**
     * 动态规划求解问题的四个特征：
     * ①求一个问题的最优解；
     * ②整体的问题的最优解是依赖于各个子问题的最优解；
     * ③小问题之间还有相互重叠的更小的子问题；
     * ④从上往下分析问题，从下往上求解问题；
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] product = new int[target + 1];
        for (int i = 0; i < 4; i++) {
            product[i] = Math.max(i, cutRope(i));
        }
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                product[i] = Math.max(product[i], product[j] * product[i - j]);
            }
        }
        return product[target];
    }

    //纯数学解法
    public int cutRope1(int target) {
        int res = 1;
        if (target > 1 && target < 4) {
            return target - 1;
        }
        while (target > 4) {
            target -= 3;
            res *= 3;
        }
        return target * res;
    }

    public static void main(String[] args) {
        System.out.println(new Jz67_CutRope().cutRope1(10));
    }
}
