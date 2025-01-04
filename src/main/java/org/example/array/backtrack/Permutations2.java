package org.example.array.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Created on 2025/1/4 18:12
 */
public class Permutations2 {

    /**
     * 所有不重复的全排列
     *
     * @param nums 输入的数组，可能包含重复数字
     * @return 所有不重复的全排列
     * 算法思路：
     * 1、对数组nums进行排序，确保重复元素被放在相邻位置
     * 2、使用回溯算法生成所有的全排列，在递归过程中跳过重复元素，确保每个排列是唯一的
     * 3、使用一个布尔数组used来标记哪些元素已经被使用，避免重复使用相同的元素
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯函数，用来生成全排列
     *
     * @param nums    排序后的数组
     * @param used    标记每个元素是否被使用
     * @param current 当前正在构造的排列
     * @param results 存储所有不重复的全排列
     */
    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> results) {
        // 终止条件，当前排列的长度与输入数组长度相等时，表示找到了一个有效的排列
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素被使用，则跳过
            if (used[i]) {
                continue;
            }

            // 跳过相邻重复的元素，确保不生成重复排列
            // !used[i - 1] 是确保只有前一个相同元素已经被使用，才能选择当前重复元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 选择当前元素
            current.add(nums[i]);
            used[i] = true;// 标记该元素被使用

            // 递归选择下一个元素
            backtrack(nums, used, current, results);

            // 撤销选择
            current.remove(current.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2};
        System.out.println(permuteUnique(nums1));

        int[] nums2 = {3, 3, 0, 3};
        System.out.println(permuteUnique(nums2));

        int[] nums3 = {1, 2, 3};
        System.out.println(permuteUnique(nums3));
    }
}
