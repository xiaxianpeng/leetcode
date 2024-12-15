package org.example.greedy.array;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * Created on 2024/11/25 17:14
 */
public class BuyAndSellStock {

    /**
     * 计算买卖一次可以获得的最大利润。
     *
     * @param prices 股票价格数组
     * @return 最大利润
     * 算法思想：
     * 寻找价格最低点之后的最大价格差
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;// 检查数组长度是否为空或长度小于2
        }
        int minPrice = Integer.MAX_VALUE;// 初始化最小价格为最大整数
        int maxProfit = 0;// 初始化最大利润为0

        for (int price : prices) {
            // 更新最低价格
            minPrice = Math.min(minPrice, price);
            System.out.println("当前价格: " + price + ", 最小价格: " + minPrice);

            // 更新最大利润
            maxProfit = Math.max(maxProfit, price - minPrice);
            System.out.println("潜在利润: " + (price - minPrice) + ", 最大利润: " + maxProfit);
        }
        // 返回计算得到的最大利润
        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1)); // 输出: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2)); // 输出: 0
    }
}
