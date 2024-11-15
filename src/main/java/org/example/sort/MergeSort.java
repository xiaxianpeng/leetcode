package org.example.sort;

import java.util.Arrays;
import org.example.util.ArrayUtil;

/**
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。'
 * * 1 申请空间，大小为两个序列之和，以便存放合并后的序列
 * * 2 设置两个指针。最初位置分别为两序列的其实位置
 * * 3 比较两指针所指向的元素，选择相对小的放入合并序列中，并移动指针到下一位置
 * * 4 重复3 直到某一指针指向末尾
 * * 5 将另一序列的剩下的元素复制到合并空间序列尾
 *
 * ******************************************************
 * 归并排序的代码框架如下：
 *
 * void sort(int[] nums, int lo, int hi) {
 *     int mid = (lo + hi) / 2;
 *     sort(nums, lo, mid);
 *     sort(nums, mid + 1, hi);
 *
 *     /-------后序遍历位置-------/
 *     // 合并两个排好序的子数组
 *     merge(nums, lo, mid, hi);
 *     /------------------------/
 * }
 * ******************************************************
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        // 有序的就不merge操作了
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    /**
     * 自底向上归并
     */
    public static <E extends Comparable<E>> void sortBottomUp(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {
            // 遍历合并的两个起始位置是i
            // 合并[i,i+sz-1]和[i+sz,Math.min(i+sz+za-1,n-1)]
            for (int i = 0; i + sz < n; i += sz + sz) {
                //System.out.println("sz: " + sz + " " + i + " " + (i + sz - 1) + " " + Math.min(i + sz + sz - 1, n - 1));
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
                }
            }
        }
    }

    /**
     * 合并两个有序数组arr[l,mid]和arr[mid+1,r]
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 当 i > mid 时，意味着第一个子数组中的所有元素都已经被处理，所以直接取第二个子数组中的元素放入 arr[k]。
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                // 当 j > r 时，意味着第二个子数组中的所有元素都已经被处理，所以直接取第一个子数组中的元素放入 arr[k]。
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                // 当 temp[i] 小于或等于 temp[j] 时，取 temp[i] 放入 arr[k]。
                arr[k] = temp[i];
                i++;
            } else {
                // 否则（temp[i] 大于 temp[j]），取 temp[j] 放入 arr[k]。
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtil.generateRandomArray(10, 1000);
        SortUtil.print(arr);
        MergeSort.sortBottomUp(arr);
        boolean sorted = SortUtil.isSorted(arr);
        System.out.println(sorted);
        SortUtil.print(arr);
    }
}
