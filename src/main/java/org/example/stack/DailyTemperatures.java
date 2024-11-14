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
 * 链接: https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/14 23:33
 */
public class DailyTemperatures {

    /**
     * 算法步骤如下：
     * 1、创建一个栈 stack 来存储温度数组的索引。
     * 2、创建一个结果数组 ans，初始化为和 temperatures 数组一样的长度，并将所有元素初始化为 0。
     * 3、遍历温度数组 temperatures 的每个元素和它的索引。
     * 4、对于每个元素，当栈不为空，并且当前元素比栈顶索引对应的温度要高时，弹出栈顶索引，并计算当前索引和弹出索引的差值，
     * 更新 ans 数组对应位置的值。
     * 5、将当前索引压入栈中。
     * 6、遍历完成后，栈中剩余的索引在 temperatures 中没有找到更高的温度，
     * 它们在 ans 数组中的值保持为 0（因为我们已经初始化了）。
     * 7、返回结果数组 ans。
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 当前温度比栈顶索引对应的温度要高
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 弹出索引
                int index = stack.pop();
                // 计算距离
                ans[index] = i - index;
            }
            // 当前温度的索引入栈
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
