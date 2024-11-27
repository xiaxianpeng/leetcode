package org.example.stack;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串
 * 的长度。
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * Created on 2024/11/27 09:43
 */
public class LongestValidParentheses {

    /**
     * 计算最长有效括号子串的长度。
     * 核心思路：使用栈来追踪括号匹配的索引。
     * 初始化栈顶为-1，以便计算第一个有效括号长度。
     * 遇到 '(' 时，将其索引入栈。遇到 ')' 时，弹出栈顶。如果栈为空，说明无法匹配，将当前索引入栈。
     * 否则，更新最长长度为当前索引减去栈顶索引。
     *
     * @param s 输入字符串
     * @return 最长有效括号子串的长度
     */
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);// 初始入栈-1，作为基准

        int maxLength = 0;// 保存最长有效括号长度


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);// 将 '(' 的索引入栈
            } else {
                stack.pop();// 遇到 ')'，弹出栈顶元素
                if (stack.isEmpty()) {
                    // 栈为空，将当前索引入栈
                    stack.push(i);
                } else {
                    // 计算有效括号长度
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Longest valid parentheses in '(()': " + longestValidParentheses("(()")); // 输出: 2
        System.out.println("Longest valid parentheses in ')()())': " + longestValidParentheses(")()())")); // 输出: 4
        System.out.println("Longest valid parentheses in '': " + longestValidParentheses("")); // 输出: 0
    }
}