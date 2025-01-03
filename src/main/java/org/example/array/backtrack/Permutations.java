package org.example.array.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Permutations {

    /**
     * 使用回溯算法生成所有可能的全排列。
     *
     * @param nums 给定的数组
     * @return 所有可能的全排列
     * 算法思路：
     * 1、从数组中选择一个数字，将其加入当前排列中
     * 2、对剩下的数字进行递归调用，继续选择未使用的数字
     * 3、当所有数字都被使用时，形成一个完整的排列并加入到结果集
     * 4、通过回溯法恢复现场，尝试其他选择
     */
    public static List<List<Integer>> permute(int[] nums) {
        // 保存所有的全排列
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯方法，生成排列。
     *
     * @param nums    剩余的数字
     * @param current 当前排列
     * @param results 存储所有的排列结果
     */
    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> results) {

        // 如果当前排列的长度等于nums的长度，说明找到了一个完整的排列
        if (current.size() == nums.length) {
            // 添加当前排列到结果列表中
            results.add(new ArrayList<>(current));
            return;
        }

        // 遍历所有数字，尝试添加到当前排列中
        for (int num : nums) {
            // 如果当前数字已经在当前排列中，跳过
            if (current.contains(num)) {
                continue;
            }

            // 添加当前数字到当前排列
            current.add(num);
            System.out.println("选择数字: " + num + " 当前排列：" + current);

            // 继续递归下一个位置的排列
            backtrack(nums, current, results);

            // 回溯：撤销选择，移除最后一个数字
            current.remove(current.size() - 1);
            System.out.println("回溯后排列: " + current);
        }
    }


    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{0, 1}));
        System.out.println(permute(new int[]{1}));
    }
}
