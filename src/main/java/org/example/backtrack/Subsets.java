package org.example.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/19 9:36 AM
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    List<List<Integer>> ans = new LinkedList<>();
    /**
     * // 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        ans.add(new LinkedList<>(track));
        System.out.println("ans = " + ans);
        // 回溯
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过start参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Subsets subset = new Subsets();
        List<List<Integer>> subsets = subset.subsets(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(subsets);

    }

}
