package org.example.array.dp;

/**
 * 0-1背包问题
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]。
 * 现在让你用这个背包装物品，每个物品只能用一次，在不超过被包容量的前提下，最多能装的价值是多少？
 */
public class Knapsack {
    /**
     * 解决思路：使用动态规划来解决0-1背包问题。我们使用一个一维数组 dp，其中 dp[i] 表示背包容量为 i 时可以获得的最大价值。
     * 在每次选择物品时，我们要倒着更新 dp 数组，确保每个物品只被选择一次。
     *
     * @param weights  物品的重量
     * @param values   物品的价值
     * @param num      物品的数量
     * @param capacity 背包的最大容量
     * @return 背包能够装载的最大价值
     */
    public static int knapsack(int[] weights, int[] values, int num, int capacity) {
        // dp[i] 表示背包容量为 i 时最大可获得的价值
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < num; i++) {
            // 遍历背包容量，从大到小更新 dp 数组
            for (int j = capacity; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        // 返回背包容量为 capacity 时的最大价值
        return dp[capacity];
    }

    public static void main(String[] args) {
        int num = 3;
        int capacity = 4;
        int[] weights = {2, 1, 3};
        int[] values = {4, 2, 3};
        System.out.println(knapsack(weights, values, num, capacity));  // 输出: 6
    }
}
