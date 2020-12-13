package com.algorithm.sword4offer;

/**
 * 题目描述:
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * <p>
 * 输入:
 * "google"
 * 返回值:
 * 4
 * <p>
 * 思路: 将问题转换为统计不同字符出现的次数，最后在统计下有没有出现一次的字符
 * 用一个数组存储统计结果,
 *
 * 小知识点： 将字符转换为对应ASCII码,只要强制类型转换就行
 * int ascii_a = 97;
 * char a = (char) ascii_a ;
 * System.out.println(a);
 * 结果为 a
 *
 * char a = 'a';
 * int ascii = (int)a;
 */
public class Jz34_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) {
            return -1;
        }
        // ASCII码 表功127个元素，
        int[] count = new int[58];
        char[] ch = str.toCharArray();
        int len = ch.length;
        for (int i = 0; i < len; i++) {
            int index = (int)ch[i] - 65;
            count[index]++;
        }
        for (int i = 0; i < ch.length; i++) {
            int index = (int)ch[i] - 65;
            if (count[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String testStr = "google";
        System.out.println(new Jz34_FirstNotRepeatingChar().FirstNotRepeatingChar(testStr));
    }
}
