package org.example.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

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
     * 使用前缀和和哈希表记录前缀和出现的次数来计算和为k的子数组个数
     *
     * @param nums 整数数组
     * @param k    目标和
     * @return 和为K的子数组个数
     */
    public static int subarraySum(int[] nums, int k) {
        // 创建一个哈希表来存储前缀和及其出现的次数
        Map<Integer, Integer> preSumCount = new HashMap<>();
        // 初始化前缀和为0的次数为1
        preSumCount.put(0, 1);

        // 记录和为k的子数组个数
        int count = 0;
        // 当前前缀和
        int currSum = 0;

        // 遍历数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            // 更新当前前缀和
            currSum += nums[i];

            // 检查是否存在一个前缀和，使得 currSum - preSum = k
            int preSum = currSum - k;

            // 如果存在，增加对应的次数到count
            if (preSumCount.containsKey(preSum)) {
                count += preSumCount.get(preSum);
            }

            // 更新哈希表中当前前缀和的次数
            preSumCount.put(currSum, preSumCount.getOrDefault(currSum, 0) + 1);
        }

        // 返回最终的子数组个数
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1));// 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2));// 2
    }
}
