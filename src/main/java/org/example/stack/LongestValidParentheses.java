package org.example.stack;

import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，
 * 找出最长有效（格式正确且连续）括号子串的长度。
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
     *
     * @param s 输入字符串
     * @return 最长有效括号子串的长度
     * 算法思路：
     * 使用栈来追踪括号匹配的索引。
     * 1、 初始化栈，将-1压入栈中作为基准索引
     * 2、遍历字符串中的每个字符：
     * a、当前字符是 '(' 时，将其索引入栈。
     * b、当前字符是 ')' 时，弹出栈顶。
     * -如果栈为空，说明无法匹配，将当前索引入栈作为新的基准。
     * -如果栈不为空，计算当前有效括号的长度为当前索引减去栈顶索引，并更新最长长度。
     * 3、遍历完成后，返回记录的最长长度
     */
    public static int longestValidParentheses(String s) {
        // 初始入栈-1，作为基准
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // 保存最长有效括号长度
        int maxLength = 0;

        // 遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // 遇到 '(' ，将其索引入栈
            if (currentChar == '(') {
                stack.push(i);
            }
            // 遇到 ')'，弹出栈顶元素，尝试匹配
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 栈为空，说明无法匹配，将当前索引入栈
                    stack.push(i);
                } else {
                    // 计算有效括号长度
                    int currentLength = i - stack.peek();
                    // 更新最大长度
                    maxLength = Math.max(maxLength, currentLength);
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
