package org.example.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/19 10:34 AM
 *
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，
 * 返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    List<List<Integer>> ans = new LinkedList<>();
    /**
     * 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();
    /**
     * track中的元素会标记为true
     */
    boolean[] used;

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        // 「路径」中的元素会被标记为 true，避免重复使用
        used = new boolean[nums.length];
        backtrack(nums);
        return ans;
    }

    /**
     * // 路径：记录在 track 中
     * // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
     * // 结束条件：nums 中的元素全都在 track 中出现
     */
    private void backtrack(int[] nums) {
        /*  触发结束条件 */
        // base case，到达叶子结点
        if (track.size() == nums.length) {
            // 收集叶子结点上的值
            ans.add(new LinkedList<>(track));
            return;
        }

        // 回溯
        for (int i = 0; i < nums.length; i++) {
            // 已经存在的 track 中的元素，不能重复选择
            if (used[i]) {
                continue;
            }

            // 做选择
            used[i] = true;
            track.addLast(nums[i]);
            // 进入下一层决策树
            backtrack(nums);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permute p = new Permute();
        List<List<Integer>> permute = p.permute(nums);
        System.out.println(permute);
    }

}
