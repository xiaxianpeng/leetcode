package org.example.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/19 10:11 AM
 *
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
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
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 */
public class Combine {

    List<List<Integer>> ans = new LinkedList<>();
    /**
     * 记录回溯算法的递归路径
     */
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }

    private void backtrack(int start, int n, int k) {
        // base case
        if (k == track.size()) {
            // 遍历到了第k层，收集当前节点的值
            ans.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 选择
            track.addLast(i);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1, n, k);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combines = combine.combine(4, 2);
        System.out.println(combines);
    }
}
