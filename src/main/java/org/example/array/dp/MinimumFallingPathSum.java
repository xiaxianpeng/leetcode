package org.example.array.dp;

/**
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * 示例 1：
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * https://leetcode.cn/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/14 16:41
 */
public class MinimumFallingPathSum {

    /**
     * 1、创建一个相同大小的 DP 数组 dp 来存储到达每个位置的最小路径和。
     * 2、初始化 dp 数组的第一行为 matrix 数组的第一行，因为第一行的元素没有上一行的元素。
     * 3、从第二行开始，逐行更新 dp 数组：
     * 对于 dp[i][j]（i 代表行，j 代表列），
     * 其值是 matrix[i][j] 加上上一行中三个可能位置的最小值（dp[i-1][j-1]，dp[i-1][j]，dp[i-1][j+1]），
     * 这三个位置可能不存在，即当 j 为 0 时不存在 dp[i-1][j-1]，j 为 n-1 时不存在 dp[i-1][j+1]。
     * 4、最后，遍历最后一行的所有元素，找出最小路径和。
     */
    public static int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        // 如果只有一行，直接返回该行的最小值
        if (length == 1) {
            return matrix[0][0];
        }

        // dp 数组初始化为输入 matrix 的复制
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[0][i] = matrix[0][i];
        }

        // 进行动态规划
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 左上角的值
                int upLeft = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                // 正上方的值
                int up = dp[i - 1][j];
                // 右上角的值
                int upRight = j < length - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                // 取三个可能方向的最小值并加上当前值
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(upLeft, upRight));
            }
        }

        // 从最后一行找出最小路径和
        int minPathSum = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            minPathSum = Math.min(minPathSum, dp[length - 1][i]);
        }
        return minPathSum;
    }

    public static void main(String[] args) {
        // 示例 1
        int[][] matrix1 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println("示例 1 输出：" + minFallingPathSum(matrix1)); // 应输出 13

        // 示例 2
        int[][] matrix2 = {
                {-19, 57},
                {-40, -5}
        };
        System.out.println("示例 2 输出：" + minFallingPathSum(matrix2)); // 应输出 -59
    }
}
