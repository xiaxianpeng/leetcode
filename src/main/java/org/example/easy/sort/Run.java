package org.example.easy.sort;


/**
 * Created by xianpeng.xia
 * on 2020/9/26 11:47 上午
 */
public class Run {


    public static void main(String[] args) {
        int[] arr = SortUtil.generateRandomArray(100);
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        SortUtil.check(arr, SelectionSort.sort(arr2));

    }
}
