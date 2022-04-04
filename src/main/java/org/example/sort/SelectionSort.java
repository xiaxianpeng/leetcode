package org.example.sort;

import org.example.bean.Person;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 11:33 上午
 * 选择排序
 * 首先在末排序序列中找到最小（大）元素，存放到排序序列的其实位置
 * 再从剩余末排序序列元素中继续寻找最小（大）元素，放到已排序列的末尾
 * 重复第二步
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 找最小的index
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            SortUtil.swap(arr, i, minIndex);
        }
        SortUtil.print(arr);
        return arr;
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j].compareTo(arr[minIndex]) < 0 ? j : minIndex;
            }
            SortUtil.swap(arr, i, minIndex);
            SortUtil.print(arr);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, 3, 5, 2, 22, 1};
        sort(arr);

        Person[] people = {new Person("a", 22), new Person("b", 21), new Person("c", 15)};
        sort(people);
        boolean sorted = SortUtil.isSorted(people);
        System.out.println(sorted);
    }
}
