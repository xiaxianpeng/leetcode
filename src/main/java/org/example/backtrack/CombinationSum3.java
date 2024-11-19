package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * 链接：https://leetcode.cn/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 17:42
 */
public class CombinationSum3 {

    /**
     * 使用回溯算法寻找所有可能的组合。
     * 递归地构建组合，满足条件时将其添加到结果列表中。
     *
     * @param k 组合中数字的个数。
     * @param n 组合中数字的和。
     * @return 所有符合条件的组合列表。
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), k, n, 1);
        return combinations;
    }

    /**
     * 辅助递归函数，用于生成组合。
     *
     * @param combinations 存储结果的列表。
     * @param combination  当前的组合。
     * @param k            剩余需要选择的数字个数。
     * @param n            目标和减去当前组合的剩余值。
     * @param start        当前选择数字的起始点。
     */
    private static void backtrack(List<List<Integer>> combinations,
                                  List<Integer> combination,
                                  int k, int n,
                                  int start) {
        // 当组合达到所需长度且和为目标值时，加入结果列表
        if (k == 0 && n == 0) {
            combinations.add(new ArrayList<>(combination));
            System.out.println("Valid combination found: " + combination);
            return;
        }

        // 当组合长度超过或和小于目标值时，停止搜索
        if (k < 0 || n < 0) {
            return;
        }

        // 尝试选择下一个数字
        for (int i = start; i <= 9; i++) {
            // 将数字加入当前组合
            combination.add(i);
            System.out.println("Adding number: " + i + ", Current combination: " + combination);
            backtrack(combinations, combination, k - 1, n - i, i + 1);// 递归处理下一个数字
            combination.remove(combination.size() - 1); // 撤销选择
            System.out.println("Removing number: " + i + ", Current combination: " + combination);
        }
    }

    public static void main(String[] args) {

        // 用例1
        System.out.println(combinationSum3(3, 7)); // 输出: [[1, 2, 4]]

        // 用例2
        System.out.println(combinationSum3(3, 9)); // 输出: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]

        // 用例3
        System.out.println(combinationSum3(4, 1)); // 输出: []
    }
}
