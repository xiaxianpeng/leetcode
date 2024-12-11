package org.example.dp.array;

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
     * 算法思路：
     * 使用动态规划的方法同时跟踪当前子数组的最大和最小乘积。
     * 1. 初始化两个变量 currentMax 和 currentMin 为第一个元素，表示以当前元素结尾的最大和最小乘积。
     * 2. 初始化全局最大乘积 maxProductOverall 为第一个元素。
     * 3. 遍历数组，从第二个元素开始：
     * * a. 如果当前元素为负数，则交换 currentMax 和 currentMin，因为乘以负数会使最大乘积变为最小，最小乘积变为最大。
     * * b. 更新 currentMax 为当前元素和 currentMax * 当前元素中的较大者。
     * * c. 更新 currentMin 为当前元素和 currentMin * 当前元素中的较小者。
     * * d. 更新全局最大乘积 maxProduct 为 currentMax 和 maxProduct 中的较大者。
     * 4. 返回全局最大乘积 maxProduct。
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 初始化currentMax和currentMin为第一个元素
        int currentMax = nums[0];
        int currentMin = nums[0];
        // 初始化全局最大元素为maxProduct
        int maxProduct = nums[0];

        // 从第二个元素开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 如果当前元素是负数，交换currentMax和currentMin
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            // 更新currentMax为nums[i]与nums[i]*currentMax的较大者
            currentMax = Math.max(nums[i], nums[i] * currentMax);
            // 更新currentMin为nums[i]与nums[i]*currentMin的较小者
            currentMin = Math.min(nums[i], nums[i] * currentMin);

            // 更新全局最大乘积
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println("Max product of [2, 3, -2, 4]: " + maxProduct(new int[]{2, 3, -2, 4})); // 输出: 6
        System.out.println("Max product of [-2, 0, -1]: " + maxProduct(new int[]{-2, 0, -1})); // 输出: 0
    }
}
