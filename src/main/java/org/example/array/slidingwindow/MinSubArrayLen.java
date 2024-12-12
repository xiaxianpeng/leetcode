package org.example.array.slidingwindow;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * Created on 2024/12/5 11:30
 */
public class MinSubArrayLen {

    /**
     * 使用滑动窗口方法查找满足条件的最小子数组长度。
     * 算法思路：
     * 1. 初始化左右指针以及当前窗口的和currentSum。
     * 2. 移动右指针扩展窗口，更新窗口和。
     * 3. 当窗口和大于等于 target 时，移动左指针收缩窗口，同时更新最小长度。
     * 4. 返回最终的最小长度，若未找到则返回 0。
     *
     * @param target 目标和
     * @param nums   输入的数组
     * @return 满足条件的最小子数组长度
     */
    public static int minSubArrayLen(int target, int[] nums) {

        // 初始化当前窗口的和
        int currentSum = 0;
        // 记录最小子数组长度
        int minLength = Integer.MAX_VALUE;

        // 初始化左右指针
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // 扩展窗口
            currentSum += nums[right];
            System.out.println("扩展窗口: [" + left + ", " + right + "], currentSum: " + currentSum);

            // 尝试收缩窗口
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                System.out.println("Valid window: [" + left + ", " + right + "], Length: " + (right - left + 1));
                // 移除窗口左边界的值
                currentSum -= nums[left];
                left++;
                System.out.println("收缩窗口: [" + left + ", " + right + "], Current sum: " + currentSum);
            }
        }

        // 如果没有找到符合条件的子数组，返回 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println("Result: " + minSubArrayLen(target1, nums1)); // 输出: 2

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println("Result: " + minSubArrayLen(target2, nums2)); // 输出: 1

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println("Result: " + minSubArrayLen(target3, nums3)); // 输出: 0
    }
}
