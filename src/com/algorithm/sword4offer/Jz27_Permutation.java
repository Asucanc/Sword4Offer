package com.algorithm.sword4offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * <p>
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * <p>
 * 示例1
 * 输入
 * "ab"
 * 返回值
 * ["ab","ba"]
 * <p>
 * 回溯法：
 * //这一段就是回溯法，这里以"abc"为例
 * <p>
 * //递归的思想与栈的入栈和出栈是一样的,某一个状态遇到return结束了之后，会回到被调用的地方继续执行
 * <p>
 * //1.第一次进到这里是ch=['a','b','c'],list=[],i=0，我称为 状态A ，即初始状态
 * //那么j=0，swap(ch,0,0)，就是['a','b','c']，进入递归，自己调自己，只是i为1，交换(0,0)位置之后的状态我称为 状态B
 * //i不等于2，来到这里，j=1，执行第一个swap(ch,1,1)，这个状态我称为 状态C1 ,再进入fun函数，此时标记为T1，i为2，那么这时就进入上一个if，将"abc"放进list中
 * /////////////-------》此时结果集为["abc"]
 * <p>
 * //2.执行完list.add之后，遇到return，回退到T1处，接下来执行第二个swap(ch,1,1)，状态C1又恢复为状态B
 * //恢复完之后，继续执行for循环，此时j=2,那么swap(ch,1,2),得到"acb"，这个状态我称为C2,然后执行fun，此时标记为T2,发现i+1=2,所以也被添加进结果集，此时return回退到T2处往下执行
 * /////////////-------》此时结果集为["abc","acb"]
 * //然后执行第二个swap(ch,1,2)，状态C2回归状态B,然后状态B的for循环退出回到状态A
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,0)
 * //               |
 * //             a|b|c(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         a|b|c   a|c|b
 * <p>
 * //3.回到状态A之后，继续for循环，j=1,即swap(ch,0,1)，即"bac",这个状态可以再次叫做状态A,下面的步骤同上
 * /////////////-------》此时结果集为["abc","acb","bac","bca"]
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,1)
 * //               |
 * //             b|a|c(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         b|a|c   b|c|a
 * <p>
 * //4.再继续for循环，j=2,即swap(ch,0,2)，即"cab",这个状态可以再次叫做状态A，下面的步骤同上
 * /////////////-------》此时结果集为["abc","acb","bac","bca","cab","cba"]
 * <p>
 * //             a|b|c(状态A)
 * //               |
 * //               |swap(0,2)
 * //               |
 * //             c|b|a(状态B)
 * //             /  \
 * //   swap(1,1)/    \swap(1,2)  (状态C1和状态C2)
 * //           /      \
 * //         c|b|a   c|a|b
 * <p>
 * //5.最后退出for循环，结束。
 */
public class Jz27_Permutation {
    /**
     * 思路： 字符串全排列，首先确认第一个字符，就是每个字符都跟第一个位置交换一次，然后接下来将后面的字符都两两交换一次。
     *
     * @param str
     * @return
     */
    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        }
        char[] charArr = str.toCharArray();
        permutation(charArr, result, 0);
        Collections.sort(result);
        return result;
    }

    private void permutation(char[] charArr, List<String> res, int index) {
        //递归出口, 已经移到最后一位了，只剩一个字符，不用再交换元素
        if (index == charArr.length - 1) {
            String temp = new String(charArr);
            if (!res.contains(temp)) {
                res.add(temp);
                return;
            }
        } else {
            // 递归过程中必要的循环，相当于abcd的排列结果是4 * (3个字符排序结果)的结果。
            for (int i = index; i < charArr.length; i++) {
                // 固定首位字符
                swap(charArr, index, i);
                // 将当前的排序结果 = 固定首位字符后 + 接下来字符的全排列问题
                permutation(charArr, res, index + 1);
                // 递归出口会在这行接着执行，上一个结果只是交换了的结果，所以我们需要交换回来，回到上一个状态
                swap(charArr, i, index);
            }
        }
    }

    //交换数组的两个下标的元素
    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public static void main(String[] args) {
        String test = "abcd";
        System.out.println(new Jz27_Permutation().permutation(test));
    }

}
