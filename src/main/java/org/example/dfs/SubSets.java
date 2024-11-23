package org.example.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
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

    private static List<Integer> t = new ArrayList<>();
    private static List<List<Integer>> ans = new ArrayList<>();

    /**
     * @param nums 数组
     * @return 遍历
     */
    public static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 空集加入ans
        ans.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            // 加入当前num到已有子集组成新的子集
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            ans.addAll(newSubsets);
        }
        return ans;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k <= nums.length; k++) {
            backtrack(0, k, new ArrayList<>(), nums);
        }
        return ans;
    }

    private static void backtrack(int start, int k, ArrayList<Integer> cur, int[] nums) {
        if (k == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(i + 1, k - 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subSets = subSets(nums);
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subSets);
        System.out.println(subsets);
    }
}
