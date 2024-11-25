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
 * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/9 20:21
 */
public class CoinChange {
    //https://leetcode.cn/problems/coin-change/solutions/6568/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/?envType=study-plan-v2&envId=labuladong-algorithm-note
    public int coinChange(int[] coins, int amount) {
        // dp 数组的大小为 amount + 1，填充的初始值也为 amount + 1
        int[] dp = new int[amount + 1];
        // 填充 dp 数组，初始值设为一个不可能的硬币数量（比amount还大的数，表示无解）
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 内层 for 循环求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        // 如果最终dp数组最后一个元素值为amount+1，则标识误解
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
