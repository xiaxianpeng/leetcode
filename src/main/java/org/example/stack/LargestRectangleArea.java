package org.example.stack;

import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 * Created on 2025/1/7 17:26
 */
public class LargestRectangleArea {

    /**
     * 通过单调栈计算柱状图中最大的矩形面积
     *
     * @param heights 柱状图的高度数组
     * @return 最大矩形的面积
     * 算法思路：
     * 使用单调递增栈来存储柱子的索引，当遇到当前柱子高度小于栈顶柱子高度时
     * 计算以栈顶柱子为高的最大面积，重复此过程直到栈为空或当前柱子高度大于栈顶
     * 最后处理栈中剩余的柱子，计算他们可能形成的最大面积
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            // 当前柱子的高度，如果超过数组长度，设置为0以触发所有剩余柱子的计算
            int currentHeight = i == heights.length ? 0 : heights[i];

            // 如果当前柱子高度小于栈顶柱子高度时，开始计算面积
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // 弹出栈顶柱子的索引
                int topIndex = stack.pop();
                // 获取弹出柱子的高度
                int height = heights[topIndex];

                // 计算宽度，如果栈为空，宽度为当前索引，否则为当前索引减去新栈顶索引减一
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                // 计算面积，并更新最大面积
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("heights = [2,1,5,6,2,3]");
        int result1 = largestRectangleArea(heights1);
        System.out.println("最大矩形面积: " + result1);

        System.out.println("===============================================");

        int[] heights2 = {2, 4};
        System.out.println("heights = [2,4]");
        int result2 = largestRectangleArea(heights2);
        System.out.println("最大矩形面积: " + result2);
    }

}
