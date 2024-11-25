package org.example.dp.array;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * link：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 13:43
 */
public class StockTradingWithFee {

    /**
     * 使用动态规划解决买卖股票问题。
     * 定义两个状态：持有股票和不持有股票，用状态转移方程更新每天的最大利润。
     *
     * @param prices 股票价格数组。
     * @param fee    交易手续费。
     * @return 最大利润。
     */
    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }

        // 定义两个数组，分别存储持有股票和不持有股票的最大利润
        // 持有股票的最大利润
        int[] hold = new int[length];
        // 不持有股票的最大利润
        int[] cash = new int[length];

        // 初始化第一天的状态
        hold[0] = -prices[0];// 第一天持有股票，利润为负
        cash[0] = 0;// 第一天不持有股票，利润为零

        System.out.println("Day 0: hold = " + hold[0] + ", cash = " + cash[0]);

        for (int i = 1; i < length; i++) {
            // 第i天持有股票的利润为：前一天持有股票 或者 前一天不持有股票后买入
            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
            // 第i天不持有股票的利润为：前一天不持有股票 或者 前一天持有股票后卖出(手续费只在卖出时一次性扣除)
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i] - fee);
            System.out.println("Day " + i + ": hold = " + hold[i] + ", cash = " + cash[i]);
        }

        // 返回最后一天不持有股票的最大利润
        return cash[length - 1];
    }

    public static void main(String[] args) {

        // 示例测试用例1
        int[] prices1 = {1, 3, 2, 8, 4, 9};
        int fee1 = 2;
        System.out.println(maxProfit(prices1, fee1)); // 输出: 8

        // 示例测试用例2
        int[] prices2 = {1, 3, 7, 5, 10, 3};
        int fee2 = 3;
        System.out.println(maxProfit(prices2, fee2)); // 输出: 6
    }


}
