package org.example.array.dp;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，
 * 使得两个子集的元素和相等。
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * Created on 2024/11/26 23:54
 * ***子集背包问题***
 */
public class PartitionEqualSubsetSum {

    /**
     * 判断是否可以将数组分割成两个子集，使得两个子集的元素和相等。
     *
     * @param nums 输入的正整数数组
     * @return 是否可以分割成两个和相等的子集
     * 算法思路：本质是背包问题。需要找到一个子集，使得其总和等于数组总和的一半。
     * 使用动态规划，定义dp[j]表示是否可以通过子集的元素和得到j
     */
    public static boolean canPartition(int[] nums) {
        // 计算数组总和
        int totalSum = Arrays.stream(nums).sum();

        // 如果总和是奇数，无法平分为两个子集
        if (totalSum % 2 != 0) {
            return false;
        }

        // 目标是找一个子集和为 sum / 2
        int target = totalSum / 2;
        // 动态规划，dp[i] 表示是否能选出若干个元素，和为 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 和为0是可以的（空集）

        // 遍历数组中的每个元素
        for (int num : nums) {
            // 遍历背包容量，从大到小更新 dp 数组，防止重复使用同一个元素
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num]; // 如果 dp[j-num] 为 true，说明 dp[j] 也可以是 true
            }
        }

        // 如果 dp[target] 为 true，说明能找到和为 target 的子集
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println(canPartition(nums1));  // 输出: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println(canPartition(nums2));  // 输出: false
    }
}
