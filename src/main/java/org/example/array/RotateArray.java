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
     * 轮转数组方法：将数组中的元素向右轮转k个位置
     * 算法思路：
     * 直接将每个元素放置到它在轮转后应该出现的位置即(i+k)%n
     *
     * @param nums 待轮转的数组
     * @param k    轮转的步数
     */
    public static void rotate(int[] nums, int k) {
        System.out.println("轮转前:" + Arrays.toString(nums));
        int n = nums.length;
        if (n == 0 || k % n == 0) {
            return;//检查边界情况，数组为空或k是n的倍数则不需要操作
        }

        k = k % n;//确保k小于n

        // 创建一个新数组用来存放轮转后的结果
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // nums[i]的新位置是(i+k)%n
            result[(i + k) % n] = nums[i];
        }

        // 将新数组的内容复制回原数组
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
        System.out.println("轮转后:" + Arrays.toString(nums));
    }

    /**
     * 轮转数组，将数组中的元素向右轮转 k 个位置
     * 思路：使用三次翻转的方法来实现数组的轮转。
     * 1、翻转整个数组：将所有元素的顺序翻转。
     * 2、翻转前 k 个元素：将原来数组中最后 k 个元素的顺序调整到目标位置。
     * 3、翻转剩余的 n-k 个元素：恢复这些元素的正确顺序。
     *
     * @param nums 输入的整数数组
     * @param k    向右轮转的步数
     */
    public static void rotate2(int[] nums, int k) {
        // 特殊情况：数组为空或者不需要轮转的情况
        if (nums == null || nums.length == 0 || k % nums.length == 0) {
            return;
        }
        k %= nums.length;// 处理 k 大于数组长度的情况
        System.out.println("原始数组: " + Arrays.toString(nums));

        // 翻转整个数组
        reverse(nums, 0, nums.length - 1);
        System.out.println("翻转整个数组: " + Arrays.toString(nums));

        // 翻转前 k 个元素
        reverse(nums, 0, k - 1);
        System.out.println("翻转前k个元素: " + Arrays.toString(nums));

        // 翻转剩余的元素
        reverse(nums, k, nums.length - 1);
        System.out.println("翻转剩余的元素: " + Arrays.toString(nums));
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

        int[] nums2 = {-1, -100, 3, 99};
        rotate2(nums2, 2);
    }
}
