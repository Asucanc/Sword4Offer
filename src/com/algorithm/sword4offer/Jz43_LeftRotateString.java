package com.algorithm.sword4offer;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * <p>
 * 示例1
 * 输入
 * "abcXYZdef",3
 * 返回值
 * "XYZdefabc"
 */
public class Jz43_LeftRotateString {
    // 解法1： 直接用字符拼接
    public String leftRotateString(String str, int n) {
        if (str.length() == 0 || n == 0) {
            return str;
        }
        int offset = n % str.length();
        return str.substring(offset) + str.substring(0, offset);
    }

    //升级版：不能用String函数，不能另外开辟空间。
    public String leftRotateString1(String str, int n) {
        int len = str.length();
        if (len == 0 || n == 0) {
            return str;
        }
        int offset = n % len;
        char[] ch = str.toCharArray();
        revertCharArr(ch, 0, offset - 1);
        revertCharArr(ch, offset, len - 1);
        revertCharArr(ch, 0, len - 1);
        return new String(ch);
    }

    private void revertCharArr(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String test = "abcXYZdef";
        System.out.println(new Jz43_LeftRotateString().leftRotateString1(test, 3));
    }
}
