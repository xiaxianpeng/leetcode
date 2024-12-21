package org.example.sort;

import java.util.Arrays;

/**
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。'
 * * 1 申请空间，大小为两个序列之和，以便存放合并后的序列
 * * 2 设置两个指针。最初位置分别为两序列的其实位置
 * * 3 比较两指针所指向的元素，选择相对小的放入合并序列中，并移动指针到下一位置
 * * 4 重复3 直到某一指针指向末尾
 * * 5 将另一序列的剩下的元素复制到合并空间序列尾
 * ******************************************************
 * 归并排序的代码框架如下：
 * void sort(int[] nums, int lo, int hi) {
 * int mid = (lo + hi) / 2;
 * sort(nums, lo, mid);
 * sort(nums, mid + 1, hi);
 * /-------后序遍历位置-------/
 * // 合并两个排好序的子数组
 * merge(nums, lo, mid, hi);
 * /------------------------/
 * }
 * ******************************************************
 */
public class MergeSort {

    private MergeSort() {
    }

    /**
     * 使用归并排序排序数组
     *
     * @param nums 待排序的数组
     * @return 排序后的数组
     */
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 归并排序算法，使用递归分治排序数组
     *
     * @param nums  待排序的数组
     * @param left  当前区间的左边界
     * @param right 当前区间的右边界
     */
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;//基本情况，单元素已经有序
        }

        // 找到中间点
        int mid = left + (right - left) / 2;
        // 递归排序左半部分
        mergeSort(nums, left, mid);
        // 递归排序右半部分
        mergeSort(nums, mid + 1, right);
        // 合并两部分
        merge(nums, left, mid, right);
    }

    /**
     * 合并两个已排序的子数组
     *
     * @param nums  待排序的数组
     * @param left  当前区间的左边界
     * @param mid   中间索引
     * @param right 当前区间的有边界
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        // 临时数组
        int[] temp = new int[right - left + 1];
        // 左边部分指针
        int i = left;
        // 右边部分指针
        int j = mid + 1;
        // 临时数组指针
        int k = 0;

        // 合并两个数组
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 处理剩余元素
        while (i <= mid) {
            temp[k++] = nums[i++];// 复制左边剩余元素
        }
        while (j <= right) {
            temp[k++] = nums[j++];// 复制右边剩余元素
        }

        // 将临时数组的数据复制回原数组
        for (int l = 0; l < k; l++) {
            nums[left + l] = temp[l];
        }
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
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums1)));  // 输出：[1, 2, 3, 5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums2)));  // 输出：[0, 0, 1, 1, 2, 5]
    }
}
