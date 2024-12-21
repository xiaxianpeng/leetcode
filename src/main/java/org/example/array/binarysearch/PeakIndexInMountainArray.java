package org.example.array.binarysearch;

/**
 * 852. 山脉数组的峰顶索引
 * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 * 返回峰值元素的下标。
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 * 示例 1：
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * Created on 2024/12/21 16:54
 */
public class PeakIndexInMountainArray {

    /**
     * 使用二分查找找到山脉数组的峰值元素的下标
     *
     * @param arr 山脉数组
     * @return 峰值元素的下标
     */
    public static int peakIndexInMountainArray(int[] arr) {
        // 初始化左右指针
        int left = 0;
        int right = arr.length - 1;

        // 二分查找
        while (left < right) {
            // 找中点
            int mid = left + (right - left) / 2;
            // 如果arr[mid] < arr[mid + 1],说明峰值在右边
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;// 峰值在右侧
            }
            // 否则，峰值在左侧或为mid
            else {
                right = mid;//峰值在左侧或为mid
            }
        }

        // 最终left=right，指向峰值
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr1));  // 输出：1

        int[] arr2 = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(arr2));  // 输出：1

        int[] arr3 = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr3));  // 输出：1

        int[] arr4 = {0, 3, 5, 12, 2};
        System.out.println(peakIndexInMountainArray(arr4));  // 输出：3
    }
}
