package org.example.array.dp;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
 * 子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 示例 1:
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {

    /**
     * 找出乘积最大的连续子数组。
     * 核心思路：动态规划。
     * 使用两个变量来追踪当前子数组的最大值和最小值，因为负数乘以最小值可能变成最大值。
     * 每次更新全局最大值。
     *
     * @param nums 输入整数数组
     * @return 最大乘积
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // 如果当前数为负数，则交换当前最大和最小
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // 更新当前最大和最小乘积
            currentMax = Math.max(num, num * currentMax);
            currentMin = Math.min(num, num * currentMin);

            // 更新全局最大乘积
            maxProduct = Math.max(maxProduct, currentMax);
            System.out.println("Index: " + i + ", Num: " + num + ", CurrentMax: " + currentMax + ", CurrentMin: " + currentMin + ", MaxProduct: " + maxProduct);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println("Max product of [2, 3, -2, 4]: " + maxProduct(new int[]{2, 3, -2, 4})); // 输出: 6
        System.out.println("Max product of [-2, 0, -1]: " + maxProduct(new int[]{-2, 0, -1})); // 输出: 0
    }
}
