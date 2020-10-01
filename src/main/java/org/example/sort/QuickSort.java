package org.example.sort;

import java.net.Socket;

/**
 * Created by xianpeng.xia
 * on 2020/10/1 5:34 下午
 *
 * 快速排序
 *
 * 1 从数列中，找一个元素，以之为轴（pivot）
 * 2 重新排序数列，所有比轴小的放轴前面，比轴大大放轴后面，
 * 在这个分区退出后，该轴就处于数列的中间位置，称之为分区操作
 * 3 递归的把小于轴的子数列和大于轴的子数列排序
 */
public class QuickSort {

    public static int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int index = partition(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
        return arr;
    }

    /**
     * @param arr 数组
     * @param leftBound 左边界 以最左为基准
     * @param rightBound 右边界
     * @return 轴的位置
     */
    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            SortUtil.print(arr);

            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }
            //交换左边比pivot大的数,且右边比pivot小的数
            if (left < right) {
                SortUtil.swap(arr, left, right);
            }

            SortUtil.print(arr);
        }
        // 将基数放到中间位置
        SortUtil.swap(arr, left, rightBound);
        SortUtil.print(arr);
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 2, 8, 1, 9, 5, 4, 6};
        sort(arr, 0, arr.length - 1);
    }
}
