package org.example.sort;

import org.example.util.ArrayGenerator;

/**
 * @date 2021/02/20
 * @time 15:05
 */
public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        if (data.length <= 1) {
            return;
        }
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            siftDown(data, i, data.length);
        }
        for (int i = data.length - 1; i >= 0; i--) {
            SortUtil.swap(data, 0, i);
            siftDown(data, 0, i);
        }
    }

    /**
     * 对data[0,n)所形成的最大堆中,索引k的元素,执行siftDown
     */
    private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
        while (2 * k + 1 < n) {
            //此轮循环中,data[k]和data[j]交换位置
            int j = 2 * k + 1;
            if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            // data[j]是leftChild和rightChild中的最大值
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            SortUtil.swap(data, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(100, 1000);
        SortUtil.print(arr);
        sort(arr);
        SortUtil.print(arr);
    }
}
