package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/3/30 2:36 PM
 * * 给定一个总的钱数，在给定几个固定面值的硬币，请问有多少种组合方法，可以得到总的钱数
 * * 特殊情况考虑：
 * * （1）总的钱数为0，组合的话只有一种；
 * * （2）硬币集合为0，组合的话只有0中。
 */
public class Coin {

    public static int count(int[] coins, int totalMoney) {
        int[] dp = new int[totalMoney + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int x = coin; x < totalMoney + 1; x++) {
                dp[x] = dp[x] + dp[x - coin];
                System.out.println(dp[x]);
            }
        }
        return dp[totalMoney];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int total = 100;
        count(coins, total);
    }
}
