package org.example.array.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * *    2
 * *   3 4
 * *  6 5 7
 * * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * Created on 2024/12/27 20:04
 */
public class MinTotal {

    /**
     * 三角形最小路径和
     *
     * @param triangle 三角形
     * @return 最小路径和
     * 算法思路：
     * 1、使用一个dp数组先保存最后一行值
     * 2、然后自底向上，逐行累加最小路径和
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp数组的大小和行数一致
        int[] dp = new int[n];

        // 1、将最后一行的值复制到dp中
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // 2、从倒数第二行往上遍历
        for (int row = n - 2; row >= 0; row--) {
            // 第row行，有row+1个元素
            for (int col = 0; col <= row; col++) {
                // dp[col],dp[col+1]分别表示当前行下方的两个相邻位置所对应的最小路径和
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // dp[0]最终存放的即是从顶到底的最小路径和
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(java.util.Arrays.asList(2));
        triangle1.add(java.util.Arrays.asList(3, 4));
        triangle1.add(java.util.Arrays.asList(6, 5, 7));
        triangle1.add(java.util.Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle1));
    }
}
