package com.algorithm.sword4offer;

/**
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * <p>
 * 示例1
 * 输入
 * "aaa","a*a"
 * 返回值
 * true
 * <p>
 * 思路：
 * 1. 如果都为空，返回true。如果pattern为空，返回false。
 */
public class Jz52_ExpressionMatch {
    public boolean match(char[] str, char[] pattern) {
        if (pattern.length == 0) {
            return str.length == 0;
        }
        return match(str, pattern, 0, 0);
    }

    private boolean match(char[] str, char[] pattern, int strIndex, int paIndex) {
        if (paIndex == pattern.length) {
            return strIndex == str.length;
        }
        if (paIndex + 1 < pattern.length && pattern[paIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[paIndex]) || (strIndex != str.length && pattern[paIndex] == '.')) {
                return match(str, pattern, strIndex, paIndex + 2)
                        || match(str, pattern, strIndex + 1, paIndex)
                        || match(str, pattern, strIndex + 1, paIndex + 2);
            } else {
                return match(str, pattern, strIndex, paIndex + 2);
            }
        }
        if ((strIndex != str.length && str[strIndex] == pattern[paIndex]) || (strIndex != str.length && pattern[paIndex] == '.')) {
            return match(str, pattern, strIndex + 1, paIndex + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String test = "a";
        String pattern = ".*";
        System.out.println(new Jz52_ExpressionMatch().match(test.toCharArray(), pattern.toCharArray()));
    }
}
