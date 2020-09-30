package org.example.sort;

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

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 1, 3, 5};
        sort(arr);
    }
}
