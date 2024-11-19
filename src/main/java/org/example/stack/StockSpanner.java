package org.example.stack;

import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * 实现 StockSpanner 类：
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * 示例：
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * 链接：https://leetcode.cn/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 12:11
 */
public class StockSpanner {

    Stack<int[]> stack;

    /**
     * 初始化数据结构。
     * 使用栈来存储股票价格和对应的跨度。
     */
    public StockSpanner() {
        // 栈中的每个元素是一个数组，数组第一个元素是价格，第二个元素是该价格的跨度
        stack = new Stack<>();
    }

    /**
     * 给定今天的股价，返回该股价的跨度。
     * 通过栈来实现，每次插入新价格时，比较栈顶价格，如果栈顶价格小于等于当前价格，则弹出栈顶并累加跨度。
     *
     * @param price 今天的股价。
     * @return 今天的股价跨度。
     */
    public int next(int price) {
        // 初始化当前价格的跨度为1
        int span = 1;
        // 当栈不为空且栈顶价格小于等于当前价格时，需要合并跨度
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // 弹出栈顶并累加其跨度
            span += stack.pop()[1];
        }

        // 当前价格和计算出的跨度入栈
        stack.push(new int[]{price, span});
        // 打印当前栈状态
        // 打印当前栈状态
        System.out.print("Stack state: [");
        for (int[] pair : stack) {
            System.out.print("(" + pair[0] + ", " + pair[1] + ") ");
        }
        System.out.println("]");

        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80));  // 返回 1
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(70));  // 返回 2
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(75));  // 返回 4
        System.out.println(stockSpanner.next(85));  // 返回 6
    }
}
