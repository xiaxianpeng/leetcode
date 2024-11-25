package org.example.backtrack.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 链接：https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    /**
     * 使用回溯算法生成所有可能的 k 个数的组合。
     *
     * @param n 范围上限
     * @param k 组合中数字的数量
     * @return 所有可能的组合
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new LinkedList<>();
        backtrack(n, k, 1, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯方法，生成组合。
     *
     * @param n       范围上限
     * @param k       组合中数字的数量
     * @param start   当前数字选择的起点
     * @param current 当前组合
     * @param results 存储所有的组合结果
     */
    private static void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> results) {
        // 如果当前组合的长度等于k，说明找到了一个完整的组合
        if (k == current.size()) {
            results.add(new ArrayList<>(current));
            return;
        }

        // 从start开始尝试所有可能的数字
        for (int i = start; i <= n; i++) {
            // 将当前数字添加到当前组合
            current.add(i);
            System.out.println("Current: " + current);

            // 继续递归，注意下一个数字的起点是i+1
            backtrack(n, k, i + 1, current, results);

            // 回溯，移除最后一个数字
            current.remove(current.size() - 1);
            System.out.println("Backtrack: " + current);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
    }
}
