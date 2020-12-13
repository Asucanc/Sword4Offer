package com.algorithm.sword4offer;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * 示例1
 * 输入
 * 4
 * 返回值
 * 5
 * 本质还是一个斐波拉契数列， 详情参考 @see {@link com.algorithm.sword4offer.Jz08_JumpSteps#jumpSteps1(int)} ;}
 */
public class Jz10_RectCover {
    public int rectCover(int target) {
        if (target > 0 && target <= 3) {
            return target;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }


}
