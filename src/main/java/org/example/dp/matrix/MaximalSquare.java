package org.example.dp.matrix;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出：4
 * 示例 2：
 * 输入：matrix = [
 * ["0","1"],
 * ["1","0"]
 * ]
 * 输出：1
 * 示例 3：
 * 输入：matrix = [["0"]]
 * 输出：0
 * Created on 2024/12/13 21:19
 */
public class MaximalSquare {

    /**
     * 计算只包含 '1' 的最大正方形面积
     *
     * @param matrix 二维字符矩阵
     * @return 最大正方形的面积
     * 动态规划解法：
     * 定义dp[row][col]表示位置(row,col)为右下角的最大正方形的边长
     * 为了保证(row,col)为右下角的正方形，要求其左边，上边和左上角都可以构成正方形
     * 取决于三个位置中最小的边长
     * 转移方程：
     * 如果matrix[row][col]为'1'；则
     * dp[row][col]=min(dp[row-1][col],dp[row][col-1],dp[row-1][col-1])+1
     * *
     * 初始化：
     * 第一行，第一列的dp值等于对应matrix的值
     * *
     * 结果：
     * 遍历dp数组，找到最大的边长，返回其平方作为最大正方形的面积
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;//特殊情况处理
        }
        int rows = matrix.length;//矩阵行数
        int cols = matrix[0].length;//矩阵列数
        int[][] dp = new int[rows][cols];//dp数组
        int maxSide = 0;//记录正方形最大边长

        // 遍历矩阵更新dp值
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        // 第一行或第一列，dp值直接为1
                        dp[row][col] = 1;
                    } else {
                        // 上，左，右
                        dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[row][col]);//更新最大边长
                }
            }
        }
        // 返回最大面积
        return maxSide * maxSide;
    }

    public static void main(String[] args) {

        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix1)); // 输出 4

        char[][] matrix2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println(maximalSquare(matrix2)); // 输出 1

        char[][] matrix3 = {
                {'0'}
        };
        System.out.println(maximalSquare(matrix3)); // 输出 0
    }

}
