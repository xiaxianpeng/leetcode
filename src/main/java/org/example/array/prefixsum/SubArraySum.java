package org.example.array.prefixsum;

import java.util.Arrays;

/**
 * 560. 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubArraySum {

    /**
     * 算法思路：
     * 1. 计算前缀和数组 perSum，其中 perSum[i] 表示 nums[0] 到 nums[i-1] 的和。
     * 2. 使用双重循环遍历所有可能的子数组，通过计算 perSum[right + 1] - perSum[left] 来获取子数组的和。
     * 3. 如果子数组的和等于 k，则计数器加一。
     * 时间复杂度为 O(n^2)，空间复杂度为 O(n)。
     */
    public static int subArraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和preSum
        int[] preSum = new int[len + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        System.out.println("前缀和数组: " + Arrays.toString(preSum));

        // 记录和为k的子数组数量
        int count = 0;
        // 遍历所有可能的子数组
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 计算子数组nums[left....right]的和
                int currentSum = preSum[right + 1] - preSum[left];
                // 如果子数组的和为k，计数器+1
                if (currentSum == k) {
                    System.out.println("找到和为 " + k + " 的子数组: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int count = subArraySum(nums, 3);
        System.out.println(count);
    }
}
