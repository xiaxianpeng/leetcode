package org.example.array.dp;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs {

    /**
     * 计算爬到楼顶的方法总数。
     * 核心思路：使用动态规划。
     * 定义 dp[i] 为爬到第 i 阶的方法总数。
     * 转移方程为 dp[i] = dp[i-1] + dp[i-2]，
     * 因爬到第 i 阶可以从第 i-1 阶（爬 1 阶）或 i-2 阶（爬 2 阶）达到。
     *
     * @param n 楼梯的阶数
     * @return 不同的方法数
     */
    public static int climbStairs(int n) {
        // 创建一个数组 dp，其中 dp[i] 表示爬到第 i 阶的方法数
        // dp[n] = dp[n-1] + dp[n-2]
        int[] dp = new int[n + 1];

        // 初始条件：到第一阶只有一种方法，到第二阶有两种方法
        dp[1] = 1;
        dp[2] = 2;

        // 从第三阶开始，应用状态转移方程计算每阶的方法数
        for (int i = 3; i <= n; i++) {
            // 爬到第 i 阶的方法数等于爬到第 i-1 阶的方法数加上爬到第 i-2 阶的方法数
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // 返回爬到第 n 阶的方法数
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Total ways to climb 2 steps: " + climbStairs(2)); // 输出: 2
        System.out.println("Total ways to climb 3 steps: " + climbStairs(3)); // 输出: 3
    }
}
