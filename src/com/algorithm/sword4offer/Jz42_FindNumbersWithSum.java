package com.algorithm.sword4offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例：
 * 输入: 1， 3， 5， 6， 7， 8， 9， 11， 14， 15，17, 18, 19, 20
 * sum: 16
 * 输出:
 */
public class Jz42_FindNumbersWithSum {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int len = array.length;
        int left = 0, right = len - 1;
        ArrayList<Integer> res = new ArrayList<>(2);
        while (left <= right) {
            int target = sum - array[left];
            while (array[right] >= target && right >= left) {
                if (array[right] == target) {
                    res.add(array[left]);
                    res.add(array[right]);
                    return res;
                }
                right--;
            }
            left++;
            right = len - 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = { 1,2,4,7,11,16 };
        List list = new Jz42_FindNumbersWithSum().findNumbersWithSum(arr, 10);
        System.out.println(list);
    }
}
