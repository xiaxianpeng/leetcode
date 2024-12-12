package org.example.dp.array;


/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * 输入：m = 3, n = 3
 * 输出：6
 */
public class UniquePaths {

    /**
     * 使用动态规划求解不同路径数量。
     * 定义dp数组，其中dp[i][j]表示从起点到达(i, j)的不同路径数量。
     * 状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *
     * @param m 网格的行数。
     * @param n 网格的列数。
     * @return 从起点到达终点的不同路径数量。
     */
    public static int uniquePaths(int m, int n) {
        // 初始化dp数组，表示每个位置的路径数量
        int[][] dp = new int[m][n];

        // 第一列的路径数量都为1，因为只能从上方到达
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
            System.out.println("dp[" + i + "][0] = 1"); // 打印初始化状态
        }

        // 第一行的路径数量都为1，因为只能从左侧到达
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
            System.out.println("dp[0][" + j + "] = 1"); // 打印初始化状态
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 当前格子的路径数来自于上方和左侧路径数之和
                // dp[i][j] 依赖 dp[i-1][j] 和 dp[i][j-1]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]); // 打印更新状态
            }
        }

        // 终点的路径数量即为结果
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 输出: 28

        System.out.println(uniquePaths(3, 2)); // 输出: 3

        System.out.println(uniquePaths(7, 3)); // 输出: 28

        System.out.println(uniquePaths(3, 3)); // 输出: 6
    }
}
