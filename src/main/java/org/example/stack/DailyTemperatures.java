package org.example.stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * Created on 2024/11/14 23:33
 */
public class DailyTemperatures {


    /**
     * 使用单调栈解决每日温度问题
     * 栈中保存的是尚未找到更高温度的天数的索引，
     * 确保栈中索引对应的温度是单调递减的
     *
     * @param temperatures 每日温度
     * @return 返回数组，表示从当前天数开始，需要多少天才能遇到更高的温度
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 遍历每一天的温度
        for (int i = 0; i < n; i++) {
            // 检查栈不为空，且当前天的温度大于栈顶天的温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();// 弹出栈顶元素，这是之前温度较低天的索引
                answer[prevIndex] = i - prevIndex; // 计算当前天与之前温度较低天的天数差
            }
            stack.push(i); // 将当前天的索引入栈
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
