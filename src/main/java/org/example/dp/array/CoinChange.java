package org.example.dp.array;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 输入：coins = [1], amount = 0
 * 输出：0
 * Created on 2024/11/9 20:21
 */
public class CoinChange {

    /**
     * 使用动态规划求解凑成总金额的最少硬币数。
     * 核心思路：定义 dp[i] 表示凑成金额 i 所需的最少硬币数。
     * 初始化：dp[0] = 0，因为凑成金额 0 需要 0 个硬币。
     * 对于每个金额 i，尝试所有硬币面额 j，更新 dp[i] 为 dp[i - j] + 1 的最小值。
     *
     * @param coins  可用硬币的面额数组
     * @param amount 目标金额
     * @return 凑成目标金额所需的最少硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // 初始化动态规划数组，长度为 amount + 1，初始值为正无穷大
        int[] dp = new int[amount + 1];
        // 使用 amount + 1 作为无穷大，因为不可能有 amount + 1 个硬币
        Arrays.fill(dp, amount + 1);

        // 凑成金额0需要0个硬币
        dp[0] = 0;

        // 计算dp数组
        for (int i = 1; i <= amount; i++) {
            // 内层 for 循环求所有选择的最小值
            for (int coin : coins) {
                if (i - coin >= 0) {// 只有在 i 大于等于 coin 时才能使用该硬币
                    // 更新dp[i]，选择最小的硬币数
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    System.out.println("dp[" + i + "] updated to " + dp[i] + " using coin " + coin);
                }
            }
        }

        // 如果 dp[amount] 还是初始值，说明无法凑成该金额
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 1};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
        coins = new int[]{2};
        amount = 1;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

}
