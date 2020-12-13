package com.algorithm.sword4offer;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Jz02_ReplaceSpace {
    // 耍赖解法
    public String replaceSpace(StringBuffer str) {
        String input = str.toString();
        String res = input.replace(" ", "%20");
        return res;
    }

    // 老老实实替换法
    public String replaceSpace1(StringBuffer str) {
        String input = str.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp == ' ') {
                sb.append("%20");
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer test = new StringBuffer("We are Happy");
        System.out.println(new Jz02_ReplaceSpace().replaceSpace1(test));
    }
}
