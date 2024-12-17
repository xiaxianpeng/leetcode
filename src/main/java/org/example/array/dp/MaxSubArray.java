package org.example.array.dp;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，
 * 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），
 * 返回其最大和。
 * 子数组
 * 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * Created on 2024/11/14 18:35
 */
public class MaxSubArray {

    /**
     * Kadane算法的核心思想是遍历数组,同时维护两个变量：currentSum 和 maxSum。
     * 变量 currentMaxSum 保存的是包含当前元素的子数组的最大和，它的值为 currentSum + nums[i] 与 nums[i] 中较大的一个，
     * 这表示我们可以选择继续累加之前的子数组，或者从当前元素开始一个新的子数组。
     * 变量 maxSum 记录的是到目前为止遍历所得的最大子数组和，每次遍历到新元素时，
     * 都会用 pre 更新 maxSum。最终，maxSum 中存储的就是整个数组的最大子数组和。
     */
    public static int maxSubArray(int[] nums) {
        // currentMaxSum 表示包含当前元素的连续子数组的最大和
        // maxSum 表示到目前为止的所有连续子数组中的最大和
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 更新包含当前元素的连续子数组的最大和
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新到目前为止的连续子数组的最大和
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("最大子数组和：" + maxSubArray(nums1)); // 输出 6

        int[] nums2 = {1};
        System.out.println("最大子数组和：" + maxSubArray(nums2)); // 输出 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("最大子数组和：" + maxSubArray(nums3)); // 输出 23
    }
}
