package org.example.backtrack.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * Created on 2024/12/27 18:07
 */
public class CombinationSum2 {

    /**
     * 求出所有总和为target的组合
     *
     * @param nums   候选数组
     * @param target 目标和
     * @return 所有满足条件的组合列表
     * 算法思路:
     * 1、对数组进行排序，以便去重和剪枝
     * 2、使用回溯法搜索所有可能的数组
     * 3、避免在同一层级出现想通元素(去重)
     */
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        // 用来存储所有满足条件的结果组合
        List<List<Integer>> results = new ArrayList<>();
        // 先排序，便于后续去重和剪枝
        Arrays.sort(nums);
        // 调用回调函数
        backtrack(nums, target, 0, new ArrayList<>(), results);
        return results;
    }

    /**
     * 回溯函数，用来生成所有可能的组合
     *
     * @param nums    候选数组
     * @param target  目标和
     * @param start   当前搜索起点索引
     * @param current 当前已经组合的列表
     * @param results 所有满足要求的最终组合列表
     */
    private static void backtrack(int[] nums, int target, int start,
                                  List<Integer> current, List<List<Integer>> results) {

        // 如果剩余目标值为0，说明找到了一组可行的组合
        if (target == 0) {
            results.add(new ArrayList<>(current));// 需要创建当前组合的副本，否则后续回溯会修改它
            System.out.println("找到可行组合: " + current);
            return;
        }

        // 如果剩余目标值小于0，说明当前路径已经超出范围，剪枝回退
        if (target < 0) {
            System.out.println("和超出目标，回溯: " + current);
            return;
        }

        // 从start索引开始搜索，避免重复选择之前的元素
        for (int i = start; i < nums.length; i++) {
            // 如果当前元素已经超过剩余目标值，后续元素会更大，直接剪枝
            if (nums[i] > target) {
                System.out.println("元素 " + nums[i] + " 超出剩余目标 " + target + "，停止当前循环");
                break;
            }

            // 去重逻辑：如果当前元素和前一个元素相同，且前一个元素没有被选过，则跳过
            // 这样可以避免同层级出现相同组合
            if (i > start && nums[i] == nums[i - 1]) {
                System.out.println("跳过重复元素: " + nums[i]);
                continue;
            }

            // 选择当前元素
            current.add(nums[i]);
            System.out.println("选择元素: " + nums[i] + "，当前组合: " + current);
            // 递归回溯：让目标值减少nums[i],并从下一个位置继续搜索
            backtrack(nums, target - nums[i], i + 1, current, results);
            // 撤回选择，回退到上一层状态
            current.remove(current.size() - 1);
            System.out.println("撤回元素: " + nums[i] + "，回到组合: " + current);
        }

    }

    public static void main(String[] args) {
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(combinationSum2(candidates1, target1));

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(combinationSum2(candidates2, target2));
    }
}
