package com.algorithm.sort;

/**
 * 归并排序 （Merge Sort）：
 * 归并排序是建立在归并操作上的一种有效的排序算法， 算法采用的是分治法（Divide and Conquer)
 * 本算法中，分治与递归可以同时进行。
 * 归并排序的思路简单，速度仅次与快速排序，为稳定排序算法，使用场景为总体无序但是局部有序的数列。
 * <p>
 * 基本思想：
 * 分解（Divide）：将n个元素分成包含n/2个元素的子序列
 * 解决（Conquer）：用合并排序对两个子序列递归的排序
 * 合并（Combine）：合并两个已排序的子序列已得到的结果
 * <p>
 * 复杂度分析：
 * 平均时间复杂度： O(nlogn)
 * 最佳时间复杂度： O(n)
 * 最差时间复杂度： O(nlogn)
 */
public class MergeAndSort {

    /**
     * 递归方式：
     *
     * @param arr
     * @param temp
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);

        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        int index = start;

        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] > arr[start2]) {
                temp[index++] = arr[start2++];
            } else {
                temp[index++] = arr[start1++];
            }
        }
        if (start1 <= end1) {
            temp[index++] = arr[start1++];
        }
        if (start2 <= end2) {
            temp[index++] = arr[start2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 迭代方式
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];

        for (int block = 1; block < len * 2; block *= 2) {
            for (int start = 0; start < len; start += block * 2) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while (start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }

        result = arr;

    }




    public static void main(String[] args) {
        int[] arr = {5, 4, 3};
        int len = arr.length;
        int[] temp = new int[len];
//        mergeSort(arr, temp, 0, len - 1.java);
        mergeSort(arr);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
