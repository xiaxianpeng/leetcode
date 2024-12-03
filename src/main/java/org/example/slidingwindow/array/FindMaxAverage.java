package org.example.slidingwindow.array;

/**
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * Created on 2024/11/18 11:32
 */
public class FindMaxAverage {

    /**
     * 使用滑动窗口计算长度为 k 的连续子数组的最大平均数。
     * 核心思路：
     * 1. 计算初始窗口的总和。
     * 2. 使用滑动窗口方法，动态调整窗口总和以寻找最大值。
     * 3. 根据最大总和计算最大平均值。
     * 时间复杂度：O(n)，其中 n 是数组长度。
     * 空间复杂度：O(1)，只使用了常数额外空间。
     */
    public static double findMaxAverage(int[] nums, int k) {
        // 初始化窗口总和为数组前 k 个元素之和
        int curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        // 初始化最大总和为初始窗口总和
        int maxSum = curSum;
        for (int i = k; i < nums.length; i++) {
            // 移动窗口：加上新元素，减去旧元素
            curSum += nums[i] - nums[i - k];
            // 更新最大总和
            maxSum = Math.max(maxSum, curSum);
        }
        // 返回最大平均值
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 输出：12.75
        System.out.println(findMaxAverage(new int[]{5}, 1));                   // 输出：5.0
    }
}
