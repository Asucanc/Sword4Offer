package com.algorithm.sword4offer;

import java.util.HashSet;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class Jz50_FindDuplicateNumber {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    // 利用HashSet来解决此题
    public boolean duplicate1(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        if (set.size() == length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1, 0, 2, 5, 3};
        int[] dup = new int[1];
        System.out.println(new Jz50_FindDuplicateNumber().duplicate1(test, test.length, dup));
        System.out.println(dup[0]);
    }
}
