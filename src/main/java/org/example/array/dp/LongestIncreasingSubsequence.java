package org.example.array.dp;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/14 17:54
 */
public class LongestIncreasingSubsequence {

    /**
     * 1、初始化一个数组 dp，其中 dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度。
     * 初始时，每个元素的最长递增子序列至少包含自己，因此 dp[i] 的初始值都为 1。
     * 2、遍历数组 nums，对于每个元素 nums[i]，再次遍历 nums[0] 到 nums[i-1]：
     * 3、如果找到一个元素 nums[j]（其中 j < i），使得 nums[j] < nums[i]，
     * 说明 nums[i] 可以在 nums[j] 的基础上构成一个更长的递增子序列。
     * 因此，可以更新 dp[i] 为 dp[j] + 1，如果 dp[j] + 1 大于当前的 dp[i]。
     * 4、在遍历的过程中，记录并更新找到的最长递增子序列的长度。
     * 5、最后，dp 数组中的最大值即为整个数组的最长递增子序列的长度。
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // 记录最长递增子序列的长度，至少为 1
        int maxLIS = 1;

        // 初始化 dp 数组
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        // 动态规划计算 LIS
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[j] 小于 nums[i]，则可以在以 nums[j] 结尾的序列上追加 nums[i]
                if (nums[j] < nums[i]) {
                    // 更新以 nums[i] 结尾的最长递增子序列的长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新全局最长递增子序列的长度
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("示例 1 - 最长递增子序列的长度：" + lengthOfLIS(nums1)); // 期望输出 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("示例 2 - 最长递增子序列的长度：" + lengthOfLIS(nums2)); // 期望输出 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("示例 3 - 最长递增子序列的长度：" + lengthOfLIS(nums3)); // 期望输出 1
    }
}
