package org.example.array;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class RotateArray {

    /**
     * 轮转数组，将数组中的元素向右轮转 k 个位置
     * 思路：使用三次反转的方法来实现数组的轮转。
     * 1、反转整个数组：将所有元素的顺序倒转。
     * 2、反转前 k 个元素：将原来数组中最后 k 个元素的顺序调整到目标位置。
     * 3、反转剩余的 n-k 个元素：恢复这些元素的正确顺序。
     *
     * @param nums 输入的整数数组
     * @param k    向右轮转的步数
     */
    public static void rotate(int[] nums, int k) {
        // 特殊情况：数组为空或者不需要轮转的情况
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;// 处理 k 大于数组长度的情况
        System.out.println("Original array: " + Arrays.toString(nums));

        // 反转整个数组
        reverse(nums, 0, nums.length - 1);
        System.out.println("After reversing entire array: " + Arrays.toString(nums));

        // 反转前 k 个元素
        reverse(nums, 0, k - 1);
        System.out.println("After reversing first k elements: " + Arrays.toString(nums));

        // 反转剩余的元素
        reverse(nums, k, nums.length - 1);
        System.out.println("After reversing remaining elements: " + Arrays.toString(nums));
    }

    /**
     * 反转数组中的一部分
     *
     * @param nums  数组
     * @param start 起始索引
     * @param end   结束索引
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums1, 3);
        System.out.println("Rotated array for nums1: " + Arrays.toString(nums1)); // 输出 [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        rotate(nums2, 2);
        System.out.println("Rotated array for nums2: " + Arrays.toString(nums2)); // 输出 [3, 99, -1, -100]
    }
}
