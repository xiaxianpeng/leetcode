package org.example.backtrack.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class SubSets {


    /**
     * 使用回溯算法生成所有可能的子集。
     *
     * @param nums 给定的整数数组
     * @return 所有可能的子集
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯方法，生成子集。
     *
     * @param nums    给定的整数数组
     * @param start   当前子集选择的起点
     * @param current 当前子集
     * @param results 存储所有的子集结果
     */
    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> results) {
        // 将当前子集添加到结果列表中
        results.add(new ArrayList<>(current));
        System.out.println("Current Subset: " + current);

        // 从start开始尝试所有可能的数字
        for (int i = start; i < nums.length; i++) {
            // 将当前数字添加到当前子集
            current.add(nums[i]);

            // 继续递归，注意下一个数字的起点是i+1
            backtrack(nums, i + 1, current, results);

            // 回溯，移除最后一个数字
            current.remove(current.size() - 1);
            System.out.println("Backtrack: " + current);
        }

    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        // 示例 2
        System.out.println(subsets(new int[]{0}));
    }
}
