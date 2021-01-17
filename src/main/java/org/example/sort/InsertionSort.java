package org.example.sort;

import org.example.util.ArrayGenerator;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 9:02 下午
 * 将第一待排序序列的第一个元素看成有序序列，把第二个元素到最后一个元素当成未排序序列
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入到有序序列的适当位置
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
     *
     * 优化排序
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
        Integer[] arr = ArrayGenerator.generateRandomArray(20, 100);
        InsertionSort.optimizedSort(arr);
        System.out.println(SortUtil.isSorted(arr));
    }
}
