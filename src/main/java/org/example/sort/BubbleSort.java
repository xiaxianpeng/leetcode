package org.example.sort;

import org.example.util.ArrayGenerator;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 4:33 下午
 *
 * 冒泡排序
 * <p>
 * 比较相邻元素，如果第一个比第二个大 就交换他们两个
 * 对每一对相邻元素作相同操作 从开始的第一对到结尾的最后一对，得到最后的元素是最大的
 * 对所有元素重复上述步骤 除了最后一个元素
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static int[] sort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            findMaxAndSwap(arr, i);
        }
        return arr;
    }

    static void findMaxAndSwap(int[] arr, int n) {
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                SortUtil.swap(arr, j, j + 1);
            }
            SortUtil.print(arr);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            // arr[n-i,n)已经排好序
            // 通过冒泡在arr[n-i-1]位置放上合适的元素
            boolean isSwapped = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    SortUtil.swap(data, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    public static <E extends Comparable<E>> void optimizedSort(E[] data) {
        for (int i = 0; i < data.length - 1; ) {
            // arr[n-i,n)已经排好序
            // 通过冒泡在arr[n-i-1]位置放上合适的元素
            int lastSwappedIndex = 0;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    SortUtil.swap(data, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }
            i = data.length - lastSwappedIndex;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(100, 100);
        SortUtil.print(arr);
        optimizedSort(arr);
        SortUtil.print(arr);
    }
}
