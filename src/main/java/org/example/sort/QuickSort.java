package org.example.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 1 从数列中，找一个元素，以之为轴（pivot）
 * 2 重新排序数列，所有比轴小的放轴前面，比轴大大放轴后面，
 * 在这个分区退出后，该轴就处于数列的中间位置，称之为分区操作
 * 3 递归的把小于轴的子数列和大于轴的子数列排序
 * ******************************************************
 * 快速排序的代码框架如下：
 * void sort(int[] nums, int lo, int hi) {
 * /-------前序遍历位置---------/
 * // 通过交换元素构建分界点 p
 * int p = partition(nums, lo, hi);
 * /--------------------------/
 * sort(nums, lo, p - 1);
 * sort(nums, p + 1, hi);
 * }
 * ******************************************************
 */

public class QuickSort {

    private QuickSort() {
    }

    /**
     * 使用快速排序对数组进行升序排序
     *
     * @param nums 数组
     * @return 排序后的数组
     */
    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序的递归函数
     *
     * @param nums 数组
     * @param low  当前处理的子数组的开始索引
     * @param high 当前处理的子数组的结束索引
     */
    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 分区操作，返回基准元素的索引
        int pivotIndex = partition(nums, low, high);
        // 递归排序基准元素左侧的子数组
        quickSort(nums, low, pivotIndex - 1);
        // 递归排序基准元素右侧的子数组
        quickSort(nums, pivotIndex + 1, high);
    }

    /**
     * 分区操作，将小于基准的元素移到基准左侧，大于基准的元素移到右侧
     *
     * @param nums 数组
     * @param low  当前处理的子数组的开始索引
     * @param high 当前处理的子数组的结束索引
     * @return 基准元素的最终位置
     */
    private static int partition(int[] nums, int low, int high) {
        // 选择最右边的元素作为基准元素
        int pivot = nums[high];
        int i = low;// i 表示小于基准元素的区域的边界(下一个可交换位置)

        // 双指针遍历数组，指针i用来标记小于基准元素的位置，j用来遍历数组
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                SortUtil.swap(nums, i, j);
                i++;
            }
        }
        SortUtil.swap(nums, i, high);
        return i;
    }

    private static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        // arr[l+1,j] < v,arr[j+1,i] >= v
        // 初始化变量 j 为 l，j 用来跟踪小于基准元素的分区的末尾。
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 选择 arr[l] 作为基准元素（轴元素），这个元素通常被称为“pivot”
            if (arr[i].compareTo(arr[l]) < 0) {
                // 如果当前元素 arr[i] 小于基准元素 arr[l]，则增加 j 的值，
                // 然后将 arr[i] 与 arr[j] 交换位置。这个操作保证了 arr[l+1] 到 arr[j] 中的所有元素都小于基准元素。
                j++;
                SortUtil.swap(arr, i, j);
            }
        }
        // 在循环结束后，将基准元素 arr[l] 交换到它的最终位置上，即 arr[j]，这时候 arr[j] 是数组中小于等于基准元素的最后一个元素。
        SortUtil.swap(arr, l, j);
        // 函数返回索引 j，此时 arr[l, j-1] 包括的元素都小于 arr[j]，而 arr[j+1, r] 包括的元素都不小于 arr[j]。
        return j;
    }

    private static <E extends Comparable<E>> void twoWaySort(E[] arr) {
        twoWaySort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void twoWaySort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = twoWayPartition(arr, l, r);
        twoWaySort(arr, l, p - 1);
        twoWaySort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int twoWayPartition(E[] arr, int l, int r) {
        // 生成[l,r]之间的随机索引
        int p = new Random().nextInt(r - l + 1) + l;
        SortUtil.swap(arr, l, p);
        //arr[l+1,i-1] <= v,arr[j+1,r] >= v
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }
            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            SortUtil.swap(arr, i, j);
            i++;
            j--;
        }
        SortUtil.swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> void threeWaySort(E[] arr) {
        threeWaySort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void threeWaySort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        Random random = new Random();
        int p = random.nextInt(r - l + 1) + l;
        SortUtil.swap(arr, l, p);

        //arr[l+1,lt] < v ,arr[lt+1,i-1] == v ,arr[gt,r] > v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                SortUtil.swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                SortUtil.swap(arr, i, gt);
            } else {// arr[i] == arr[l]
                i++;
            }
        }
        SortUtil.swap(arr, l, lt);
        // arr[l,lt-1] > v ,arr[lt,gt-1] == v ,arr[gt,r] > v

        threeWaySort(arr, l, lt - 1);
        threeWaySort(arr, gt, r);
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums1)));  // 输出：[1, 2, 3, 5]

        int[] nums2 = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums2)));  // 输出：[0, 0, 1, 1, 2, 5]

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(Arrays.toString(sortArray(nums3)));  // 输出：[1,1,1,1]
    }
}
