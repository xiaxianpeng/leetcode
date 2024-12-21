package org.example.array.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * 983. 最低票价
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
 * 在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。
 * 每一项是一个从 1 到 365 的整数。
 * 火车票有 三种不同的销售方式 ：
 * 一张 为期一天 的通行证售价为 costs[0] 美元；
 * 一张 为期七天 的通行证售价为 costs[1] 美元；
 * 一张 为期三十天 的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。
 * 例如，如果我们在第 2 天获得一张 为期 7 天 的通行证，
 * 那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * <p>
 * 返回 你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费 。
 * 示例 1：
 * 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
 * 输出：11
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
 * 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
 * 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
 * 你总共花了 $11，并完成了你计划的每一天旅行。
 * 示例 2：
 * 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * 输出：17
 * 解释：
 * 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
 * 在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
 * 在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。
 * 你总共花了 $17，并完成了你计划的每一天旅行。
 * Created on 2024/12/21 09:17
 */
public class MinCostTickets {

    /**
     * 动态规划方法，计算最低花费
     * 对于每个旅行日，选择最优的票务方案
     * 使用dp数组记录每天的最小花费
     *
     * @param days 旅行的天数数组
     * @param cost 每种票的价格
     * @return 最低花费
     */
    public static int minCostTickets(int[] days, int[] cost) {

        // 创建一个set，存储旅行的天，方便查询是否是旅行日
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // dp[i]表示第i天的最小花费
        int[] dp = new int[366];
        // 没有旅行就没有花费
        dp[0] = 0;


        // 遍历所有的天数
        for (int i = 1; i <= 365; i++) {
            // 如果是旅行日，选购买1，7，30天票的最小花费
            if (travelDays.contains(i)) {
                // 选购买一天票
                dp[i] = dp[i - 1] + cost[0];
                // 选购买七天票
                if (i >= 7) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + cost[1]);
                } else {
                    dp[i] = Math.min(dp[i], cost[1]);
                }
                // 选购买三十天票
                if (i >= 30) {
                    dp[i] = Math.min(dp[i], dp[i - 30] + cost[2]);
                } else {
                    dp[i] = Math.min(dp[i], cost[2]);
                }
            }
            // 如果不是旅行日，继承昨天的最小花费
            else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[365];
    }

    public static void main(String[] args) {
        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println(minCostTickets(days1, costs1));  // 输出: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println(minCostTickets(days2, costs2));  // 输出: 17
    }
}