package org.example.sort;

import org.example.util.ArrayUtil;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 9:02 下午
 * 插入排序
 * 将第一待排序序列的第一个元素看成有序序列，把第二个元素到最后一个元素当成未排序序列
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入到有序序列的适当位置；；；
 * ***
 * 算法思想：
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，
 * 在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束；；；
 * ***
 * 插入排序也包含两种操作，一种是元素的比较，一种是元素的移动。
 * 当我们需要将一个数据 a 插入到已排序区间时，需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置。
 * 找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，这样才能腾出位置给元素 a 插入。
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {

        SortUtil.print(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                    SortUtil.print(arr);
                }
            }
        }
        return arr;
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
            SortUtil.print(arr);
        }
    }

    /**
     * @param arr 数组
     * @param <E> 范型
     *            <p>
     *            优化排序
     */
    public static <E extends Comparable<E>> void optimizedSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            SortUtil.print(arr);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtil.generateRandomArray(20, 100);
        InsertionSort.optimizedSort(arr);
        System.out.println(SortUtil.isSorted(arr));
    }
}
