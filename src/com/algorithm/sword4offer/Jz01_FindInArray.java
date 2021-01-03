package com.algorithm.sword4offer;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例1
 * 输入：
 * 7,[[1.java,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 *
 * 输出：
 * true
 *
 * 思路：
 * 每次将查找的数字与右上角的数字作比较，根据比较的情况分为3种：
 * 1. 相等， 结束查找
 * 2. target < 右上角。 排除最右边的一列
 * 3. target > 右上角。 排除最上面的一行
 *
 * 为什么选择右上角这个点，因为刚好这个位置是这一行的最大值和这一列的最小值，相当于二分法的中点，能排除较大的范围。
 *
 * 二位数数组初始化
 *
 * {{1.java,2,3}, {4,5,6}}
 * 写作arr[2][3], 这是一个2行3列的数组。
 * 数组初始化是以行初始化的！！！！ 我是傻逼，被这个卡了好久！
 *
 */
public class Jz01_FindInArray {

    public boolean find(int target, int[][] array) {
       int rowLen = array.length;
       int columnLen = array[0].length;
       int rowIndex = 0;
       int columnIndex = columnLen - 1;
       while (rowIndex < rowLen && columnIndex >= 0) {
           if (target == array[rowIndex][columnIndex]) {
               return true;
           } else if (target > array[rowIndex][columnIndex]) {
               rowIndex++;
           } else {
               columnIndex--;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        Jz01_FindInArray findInArray = new Jz01_FindInArray();
        int[][] arr =  {{}};
        System.out.println(findInArray.find(80, arr));
    }


}
