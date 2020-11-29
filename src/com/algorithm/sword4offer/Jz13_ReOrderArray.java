package com.algorithm.sword4offer;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 示例1：
 * 输入
 * 2，3，5，6，7，9
 * 输出
 * 3，5，7，9，2，6
 */
public class Jz13_ReOrderArray {
    public void reOrderArray(int [] array) {
        int len = array.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] %2 == 1) {
                int tmp = array[i];
                for (int j = i; j > count; j--) {
                    array[j] = array[j-1];
                }
                array[count] = tmp;
                count++;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 3, 5, 7};
        Jz13_ReOrderArray reOrderArray = new Jz13_ReOrderArray();
        reOrderArray.reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
