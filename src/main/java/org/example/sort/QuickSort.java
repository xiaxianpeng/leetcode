package org.example.sort;

import java.net.Socket;
import java.util.Random;
import org.example.util.ArrayGenerator;

/**
 * Created by xianpeng.xia
 * on 2020/10/1 5:34 下午
 * <p>
 * 快速排序
 * <p>
 * 1 从数列中，找一个元素，以之为轴（pivot）
 * 2 重新排序数列，所有比轴小的放轴前面，比轴大大放轴后面，
 * 在这个分区退出后，该轴就处于数列的中间位置，称之为分区操作
 * 3 递归的把小于轴的子数列和大于轴的子数列排序
 */
public class QuickSort {

    private QuickSort() {
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }
        int index = partition(arr, left, right);
        sort(arr, left, index - 1);
        sort(arr, index + 1, right);
        return arr;
    }

    /**
     * @param arr        数组
     * @param leftBound  左边界 以最左为基准
     * @param rightBound 右边界
     * @return 轴的位置
     */
    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            SortUtil.print(arr);

            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }
            //交换左边比pivot大的数,且右边比pivot小的数
            if (left < right) {
                SortUtil.swap(arr, left, right);
            }

            SortUtil.print(arr);
        }
        // 将基数放到中间位置
        SortUtil.swap(arr, left, rightBound);
        SortUtil.print(arr);
        return left;
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
        //arr[l+1,j] < v,arr[j+1,i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 以arr[l]做轴
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                SortUtil.swap(arr, i, j);
            }
        }
        SortUtil.swap(arr, l, j);
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
        Integer[] arr = ArrayGenerator.generateRandomArray(100, 20);
        SortUtil.print(arr);
        threeWaySort(arr);
        SortUtil.print(arr);
    }
}
