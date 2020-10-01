package org.example.sort;

/**
 * Created by xianpeng.xia
 * on 2020/10/1 4:04 下午
 *
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。'
 *
 * * 1 申请空间，大小为两个序列之和，以便存放合并后的序列
 * * 2 设置两个指针。最初位置分别为两序列的其实位置
 * * 3 比较两指针所指向的元素，选择相对小的放入合并序列中，并移动指针到下一位置
 * * 4 重复3 直到某一指针指向末尾
 * * 5 将另一序列的剩下的元素复制到合并空间序列尾
 */
public class MergeSort {

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
     * @param arr 数组
     * @param leftPtr 左指针
     * @param rightPtr 右指针
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

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 8, 3, 6, 9};
        sort(arr, 0, arr.length - 1);
    }
}
