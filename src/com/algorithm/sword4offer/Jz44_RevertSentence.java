package com.algorithm.sword4offer;

/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Jz44_RevertSentence {
    //解法1： 针对这道题 可以简单的先将单词拆分，以单词为最小元素进行位置的互换
    public String reverseSentence(String str) {
        String[] words = str.split(" ");
        int len = words.length;
        if (len == 0) {
            return str;
        }
        for (int i = 0; i < len / 2; i++) {
            String tmp = words[i];
            words[i] = words[len - 1 - i];
            words[len - 1 - i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[len - 1]);
        return sb.toString();
    }

    //解法2： 将单词转换为字符数组，进行两次位置互换。第一次全局，第二次针对单词
    //注意点： 在循环中如果需要根据循环索引计算得到新的值，如下面的 leftIndex = i + 1.java, 不能写作 left = i++;
    public String revertSentenceByCharArray(String str) {
        if ("".equals(str) || str == null) {
            return str;
        }
        char[] words = str.toCharArray();
        int len = words.length;
        swap(words, 0, len - 1);
        int leftIndex = 0;
        for (int i = 0; i < len; i++) {
            if (words[i] == ' ' && leftIndex <= len) {
                swap(words, leftIndex, i - 1);
                leftIndex = i+1;
            }
        }
        swap(words, leftIndex, len - 1);
        return new String(words);

    }

    public void swap(char[] arr, int left, int right) {
        for (int i = 0; i < (right - left + 1) / 2; i++) {
            char tmp = arr[left + i];
            arr[left + i] = arr[right - i];
            arr[right - i] = tmp;
        }
    }


    public static void main(String[] args) {
        Jz44_RevertSentence jz44RevertSentence = new Jz44_RevertSentence();
        String testStr = "YOU AM I";
        System.out.println(jz44RevertSentence.revertSentenceByCharArray(testStr));
    }
}
