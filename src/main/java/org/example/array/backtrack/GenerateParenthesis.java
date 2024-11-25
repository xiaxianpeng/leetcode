package org.example.array.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class GenerateParenthesis {

    /**
     * 生成所有可能的有效括号组合。
     *
     * @param n 括号对数
     * @return 有效括号组合的列表
     */
    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuffer(), results);
        return results;
    }

    /**
     * 辅助函数，通过回溯生成括号组合。
     *
     * @param maxPairs   括号对数
     * @param leftCount  已使用的左括号数量
     * @param rightCount 已使用的右括号数量
     * @param current    当前构建的括号组合
     * @param results    存储结果的列表
     */
    private static void backtrack(int maxPairs, int leftCount, int rightCount, StringBuffer current, List<String> results) {
        // 如果当前构建的括号组合长度等于 2 * maxPairs，则已完成一个有效组合
        if (current.length() == maxPairs * 2) {
            results.add(current.toString());
            System.out.println("Complete combination: " + current.toString());
            return;
        }
        // 如果左括号数量小于 maxPairs，添加左括号并继续递归
        if (leftCount < maxPairs) {
            current.append("(");
            System.out.println("Adding '(': " + current.toString());

            backtrack(maxPairs, leftCount + 1, rightCount, current, results);

            current.deleteCharAt(current.length() - 1);// 回溯，移除最后一个字符
            System.out.println("Backtracking after '(': " + current.toString());
        }

        if (rightCount < leftCount) {
            current.append(")");
            System.out.println("Adding ')': " + current.toString());

            backtrack(maxPairs, leftCount, rightCount + 1, current, results);

            current.deleteCharAt(current.length() - 1);// 回溯，移除最后一个字符
            System.out.println("Backtracking after ')': " + current.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); // 输出: ["((()))","(()())","(())()","()(())","()()()"]

        System.out.println(generateParenthesis(1)); // 输出: ["()"]
    }
}
