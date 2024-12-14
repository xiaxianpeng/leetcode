package org.example.array.dp;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 * Created on 2024/12/14 15:25
 */
public class HouseRobber2 {

    /**
     * @param nums 每个房屋的金额数组
     * @return 最大可盗金额
     * 核心思路：
     * 将环形问题拆分为两个独立的直线问题
     * 1、忽略最后一间房屋，求[0,n-2]的最大偷窃额
     * 2、忽略第一个间房屋，求[1,n-1]的最大偷窃额
     * 对这两个区间分别求最大盗窃额，然后返回二者的最大值
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        // 只有一个房间，直接返回
        if (n == 1) {
            return nums[0];
        }
        // 若只有两个房间，选较大的一间
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 情况1：忽略最后一个房间
        int skipLast = robLinear(nums, 0, n - 2);
        // 情况2：忽略第一个房间
        int skipFirst = robLinear(nums, 1, n - 1);
        return Math.max(skipLast, skipFirst);
    }

    /**
     * 在直线区间[start,end]内求最大可盗金额
     * 使用两个变量实现滚动更新
     * prevMax：处理到上一间房的最大收益
     * currMax：处理到当前房子时的最大收益
     * 每处理一间新房子：
     * - 若偷取此房:收益为prevMax+nums[i]
     * - 若不偷取此房：收益为currMax(上一步的最大收益，不做改变)
     *
     * @param nums  房屋金额数组
     * @param start 起始下标
     * @param end   结束下标
     * @return 在该区间内可获得的最大金额
     */
    private static int robLinear(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = start; i <= end; i++) {
            // 计算考虑当前房屋后的最大收益
            int nextMax = Math.max(currMax, prevMax + nums[i]);
            // 将状态前移：上一轮的当前值变为这一轮的前值
            prevMax = currMax;
            // 将这一轮计算的结果作为新的当前值
            currMax = nextMax;
        }
        return currMax;
    }

    /**
     * 求线性排列房屋的最大可盗金额(打家劫舍I的逻辑)
     * 使用两个变量滚动更新
     * prevMax：前一间房屋处理后的最大收益
     * currMax: 当前处理到的房屋时的最大收益
     *
     * @param nums  数组
     * @param start 起始下标
     * @param end   结束下标
     * @return 在[start, end]区间内的最大可盗金额
     */
    private static int robLinear2(int[] nums, int start, int end) {
        // 如果区间只有一个元素，直接返回该元素值
        if (start == end) {
            return nums[start];
        }

        // 初始化dp数组
        int length = end - start + 1;
        int[] dp = new int[length];
        // dp[0]对应nums[start]
        dp[0] = nums[start];
        // dp[1]对应两间房屋，偷最大的一间
        dp[1] = Math.max(nums[start], nums[start + 1]);

        // 动态规划计算,从dp[2]开始计算
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        // dp数组最后一个元素表示最大收益
        return dp[length - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        System.out.println("Max amount: " + rob(nums1));// 输出：3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println("Max amount: " + rob(nums2)); // 输出：4

        int[] nums3 = {1, 2, 3};
        System.out.println("Max amount: " + rob(nums3)); // 输出：3
    }
}
