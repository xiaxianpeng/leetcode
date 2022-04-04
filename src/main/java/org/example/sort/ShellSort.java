package org.example.sort;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 9:25 下午
 * 希尔排序，也称递减增量排序算法
 * 是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 *
 * 先将整个待排序序列分割为若干子序列进行插入排序，使得整个序列基本有序，再进行插入排序
 */
public class ShellSort {

    public static int[] sort(int[] arr) {
        SortUtil.print(arr);
        // Knuth序列
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {

            for (int i = 1; i < arr.length; i++) {

                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        SortUtil.swap(arr, j, j - gap);
                    }
                    SortUtil.print(arr);
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
    }
}
