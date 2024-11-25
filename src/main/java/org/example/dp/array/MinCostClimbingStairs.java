package org.example.dp.array;

/**
 * 746. 使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/18 19:22
 */
public class MinCostClimbingStairs {

    /**
     * 算法思想：
     * - 动态规划解法，定义 dp[i] 为到达第 i 个台阶的最小花费。
     * - 转移方程：dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
     * - 初始状态：dp[0] = dp[1] = 0。
     * - 最终答案是 dp[n]，表示到达顶部的最小花费。
     */
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        // dp 数组，dp[i] 表示到达第 i 个台阶的最小花费
        int[] dp = new int[length + 1];
        // 初始化起点
        dp[0] = 0;
        dp[1] = 0;
        // 递推计算 dp[i]
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        // 示例 1
        int[] cost1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost1)); // 输出：15

        // 示例 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost2)); // 输出：6
    }
}
