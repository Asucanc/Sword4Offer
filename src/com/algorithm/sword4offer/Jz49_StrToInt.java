package com.algorithm.sword4offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 返回值描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 示例1
 * 输入
 * "+2147483647"
 * 返回值
 * 2147483647
 * <p>
 * 示例2
 * 输入
 * "1a33"
 * 返回值
 * 0
 */
public class Jz49_StrToInt {
    public int strToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] ch = str.toCharArray();
        int res = 0;
        boolean isPositive = true;
        for (int i = 0; i < ch.length; i++) {
            int code = ch[i] - 48;
            if (code >= 0 && code <= 9) {
                res = 10 * res + code;
            } else if (code != -5 && code != -3) {
                return 0;
            } else {
                isPositive = code == -5;
            }
        }
        return isPositive ? res : 0 -  res;
    }

    public static void main(String[] args) {
        String test = "-123";
        System.out.println(new Jz49_StrToInt().strToInt(test));
    }
}
