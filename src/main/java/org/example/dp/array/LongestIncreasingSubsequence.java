package org.example.dp.array;

import java.util.Arrays;

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
 * Created on 2024/11/14 17:54
 */
public class LongestIncreasingSubsequence {


    /**
     * 使用dp求解最长递增子序列的长度
     *
     * @param nums 数组
     * @return 最长递增子序列长度
     * 算法思路：
     * 构建一个dp数组，其中dp[i]表示以nums[i]结尾的最长递增子序列的长度
     * 遍历数组并更新dp[i]的值，并记录最大长度
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;// 边界情况，直接返回0
        }

        // dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // 初始化dp数组，每个位置的初始值为1
        Arrays.fill(dp, 1);

        // 记录最长递增子序列的长度，至少为1
        int maxLength = 1;

        // 遍历
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果nums[i]>nums[j]，更新dp[i]
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大长度
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("最长递增子序列的长度：" + lengthOfLIS(nums1)); // 期望输出 4

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("最长递增子序列的长度：" + lengthOfLIS(nums2)); // 期望输出 4

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("最长递增子序列的长度：" + lengthOfLIS(nums3)); // 期望输出 1
    }
}
