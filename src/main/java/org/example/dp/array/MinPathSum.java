package org.example.dp.array;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * Created on 2024/11/27 10:13
 */
public class MinPathSum {

    /**
     * 计算从左上角到右下角的最小路径和。
     * 核心思路：使用动态规划。
     * 我们用一个二维数组 dp 来存储到达每个位置的最小路径和。
     * dp[row][col] = grid[row][col] + min(dp[row-1][col], dp[row][col-1])
     *
     * @param grid 输入的网格
     * @return 最小路径和
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        // 初始化动态规划数组，行和列数与网格相同
        int[][] dp = new int[rows][cols];

        // 初始化起点
        dp[0][0] = grid[0][0];

        // 初始化第一列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = grid[row][0] + dp[row - 1][0];
            System.out.println("Init dp[" + row + "][0] = " + dp[row][0]);
        }

        // 初始化第一行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = grid[0][col] + dp[0][col - 1];
            System.out.println("Init dp[0][" + col + "] = " + dp[0][col]);
        }

        // 填充剩余的 dp 表
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                // grid[row][col] + min(上,左)
                dp[row][col] = grid[row][col] + Math.min(dp[row - 1][col], dp[row][col - 1]);
                System.out.println("Update dp[" + row + "][" + col + "] = " + dp[row][col]);
            }
        }

        // 返回右下角的值
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grip1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Min path sum for grid1: " + minPathSum(grip1)); // 输出: 7

        int[][] grip2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println("Min path sum for grid2: " + minPathSum(grip2)); // 输出: 12
    }
}
