package org.example.backtrack.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 * Created on 2024/11/25 12:51
 */
public class CombinationSum {

    /**
     * 使用回溯算法生成所有可能的组合。
     *
     * @param candidates 候选数字数组
     * @param target     目标和
     * @return 所有可能的组合列表
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    /**
     * 辅助函数，使用回溯生成组合。
     *
     * @param candidates 候选数字数组
     * @param target     当前目标和
     * @param start      当前数字选择的起点
     * @param current    当前组合
     * @param results    存储结果的列表
     */
    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> results) {
        // 如果目标和为0，表示找到一个有效组合
        if (target == 0) {
            results.add(new ArrayList<>(current));
            System.out.println("Complete combination: " + current);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            // 如果当前数字大于目标和，跳过
            if (candidate > target) {
                continue;
            }

            // 选择当前数字
            current.add(candidates[i]);
            System.out.println("Adding number: " + candidate + ", current combination: " + current);

            // 递归处理，注意 target 减去当前选择的数字
            backtrack(candidates, target - candidates[i], i, current, results);

            // 撤销选择
            current.remove(current.size() - 1);
            System.out.println("Backtracking, removing number: " + candidate + ", current combination: " + current);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // 输出: [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8)); // 输出: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        System.out.println(combinationSum(new int[]{2}, 1)); // 输出: []
    }
}
