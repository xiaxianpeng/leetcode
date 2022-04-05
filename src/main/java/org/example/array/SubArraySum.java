package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/5 11:51 AM
 *
 * 560. 和为K的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class SubArraySum {

    /**
     * 使用区间和求解
     */
    public static int subArraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和
        int[] perSum = new int[len + 1];
        for (int i = 0; i < nums.length; i++) {
            perSum[i + 1] = nums[i] + perSum[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和[left,right],注意下标偏移
                if (perSum[right + 1] - perSum[left] == k) {
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
