package org.example.sort;

/**
 * Created by xianpeng.xia
 * on 2020/9/26 4:33 下午
 *
 * 比较相邻元素，如果第一个比第二个大 就交换他们两个
 * 对每一对相邻元素作相同操作 从开始的第一对到结尾的最后一对，得到最后的元素是最大的
 * 对所有元素重复上述步骤 除了最后一个元素
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            findMaxAndSwap(arr, i);
        }
        return arr;
    }

    static void findMaxAndSwap(int[] arr, int n) {
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                SortUtil.swap(arr, j, j + 1);
            }
            SortUtil.print(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 1, 3, 5};
        sort(arr);
    }
}
