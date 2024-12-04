package org.example.greedy.array;

import java.util.Arrays;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 * 示例 1：
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3。
 * 最大总利润为 4 + 3 = 7 。
 * 示例 2：
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4。
 * 最大总利润为 4 。
 * 示例 3：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0。
 * Created on 2024/12/4 12:56
 */
public class BuyAndSellStock2 {

    /**
     * 计算最大利润的核心方法
     * 思路：
     * 1. 在每一次价格上涨时进行买卖操作，累加利润。
     * 2. 因为可以多次交易，所以只要后面的价格高于前面的价格，就可以获取利润。
     */
    public static int maxProfit(int[] prices) {
        // 如果数组为空或长度小于2，则无法进行任何操作，直接返回0
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // 用于记录最大利润
        int maxProfit = 0;

        // 遍历价格数组，从第二天开始
        for (int i = 1; i < prices.length; i++) {
            // 如果当前价格大于前一天的价格，进行交易
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];// 累加利润
            }
        }

        return maxProfit;// 返回最大利润
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit for prices " + Arrays.toString(prices1) + " is: " + maxProfit(prices1));

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Max profit for prices " + Arrays.toString(prices2) + " is: " + maxProfit(prices2));

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Max profit for prices " + Arrays.toString(prices3) + " is: " + maxProfit(prices3));
    }
}
