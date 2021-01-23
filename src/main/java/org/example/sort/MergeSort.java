package org.example.sort;

import java.util.Arrays;
import org.example.util.ArrayGenerator;

/**
 * Created by xianpeng.xia
 * on 2020/10/1 4:04 下午
 * <p>
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。'
 * <p>
 * * 1 申请空间，大小为两个序列之和，以便存放合并后的序列
 * * 2 设置两个指针。最初位置分别为两序列的其实位置
 * * 3 比较两指针所指向的元素，选择相对小的放入合并序列中，并移动指针到下一位置
 * * 4 重复3 直到某一指针指向末尾
 * * 5 将另一序列的剩下的元素复制到合并空间序列尾
 */
public class MergeSort {

    private MergeSort() {
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left == right) {
            return arr;
        }
        int mid = left + (right - left) / 2;
        //左边排序
        sort(arr, left, mid);
        //右边排序
        sort(arr, mid + 1, right);
        //归并
        merge(arr, left, mid + 1, right);
        return arr;
    }

    /**
     * 保证左右排好序
     *
     * @param arr        数组
     * @param leftPtr    左指针
     * @param rightPtr   右指针
     * @param rightBound 右边界
     */
    static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr, j = rightPtr, k = 0;

        while (i <= mid && j <= rightBound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }
        SortUtil.print(arr);
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 有序的就不merge操作了
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    /**
     * 合并两个有序数组arr[l,mid]和arr[mid+1,r]
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayGenerator.generateRandomArray(100, 1000);
        SortUtil.print(arr);
        MergeSort.sort(arr);
        boolean sorted = SortUtil.isSorted(arr);
        System.out.println(sorted);
        SortUtil.print(arr);
    }
}
