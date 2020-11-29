package com.algorithm.sword4offer;

import java.util.ArrayList;

/**
 * 题目描述:
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1.java,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4
 * <p>
 * 示例1
 * 输入
 * [4,5,1.java,6,2,7,3,8],4
 * 返回值
 * [1.java,2,3,4]
 */
public class Jz29_GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length) {
            return arrayList;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i; j < input.length; j++) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Jz29_GetLeastNumbers getLeastNumbers = new Jz29_GetLeastNumbers();
        int[] input = {1, 2, 3, 0, 7, -1, 6};
        System.out.println(getLeastNumbers.getLeastNumbers_Solution(input, 3));
    }

}
