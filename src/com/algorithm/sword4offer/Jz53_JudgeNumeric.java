package com.algorithm.sword4offer;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 示例1
 * 输入
 * "123.45e+6"
 * 返回值
 * true
 * <p>
 * 示例2
 * 输入
 * "1.2.3"
 * 返回值
 * false
 */
public class Jz53_JudgeNumeric {
    public boolean isNumeric(char[] str) {
        int pointCount = 0;
        boolean eFlag = false;
        for (int i = 0; i < str.length; i++) {
            if (isMinsSign(str[i]) || isPlusSign(str[i])) {
                if (i > 0 && !isIgnoreCaseOfE(str[i - 1])) {
                    return false;
                }
            } else if (str[i] == '.') {
                pointCount++;
                if (pointCount > 1 || eFlag) {
                    return false;
                }
            } else if (isIgnoreCaseOfE(str[i])) {
                if (eFlag) {
                    return false;
                } else {
                    eFlag = true;
                }
                if (i == str.length - 1) {
                    return false;
                }
            } else if (!isPureNumber(str[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isPureNumber(char c) {
        int code = c - 48;
        return code >= 0 && code <= 9;
    }

    private boolean isPlusSign(char c) {
        return (int) c == 43;
    }

    private boolean isMinsSign(char c) {
        return (int) c == 45;
    }

    private boolean isIgnoreCaseOfE(char c) {
        return c == 'e' || c == 'E';
    }

    public static void main(String[] args) {
        String test = "123.45e+6";
        char[] testData = test.toCharArray();
        System.out.println(new Jz53_JudgeNumeric().isNumeric(testData));
    }

}
