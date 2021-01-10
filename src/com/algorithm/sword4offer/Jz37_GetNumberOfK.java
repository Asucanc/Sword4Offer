package com.algorithm.sword4offer;

/**
 * 统计一个数字在升序数组中出现的次数。
 * 示例1：
 * 输入：
 * [1,2,3,3,3,3,4,5],3
 * 返回值：
 * 4
 */
public class Jz37_GetNumberOfK {
    public int getNumberOfK(int[] array, int k) {
       if (array.length <= 0 || array == null) {
           return 0;
       }
       int start = binarySearch(array, k);
       int end = binarySearch(array, k + 1);
       if (start == array.length) {
           return 0;
       } else {
           return end - start;
       }
    }

    private int binarySearch(int[] array, int k) {
        int len = array.length;
        int left = 0, right = len;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int arr[] = { 1,3,3,3,3,4,5};
        System.out.println(new Jz37_GetNumberOfK().getNumberOfK(arr, 6));
    }
}
