package com.algorithm.sword4offer;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * 思路：
 * 本体的本质就是一个升序排序问题，只是比较的方式不用，需要找出两个数需要放前面最小的那个数，
 * 比较过程中两个数的值可能长度不一，需要拼接在一起构成等长去比较。
 */
public class Jz32_PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        if (len < 1)
            return "";
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                String s1 = String.valueOf(numbers[j]) + String.valueOf(numbers[j + 1]);
                String s2 = String.valueOf(numbers[j + 1]) + String.valueOf(numbers[j]);
                if (s1.compareTo(s2) > 0) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(numbers[i]);
        }

        return stringBuilder.toString();
    }
}
