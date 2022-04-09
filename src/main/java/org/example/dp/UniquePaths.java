package org.example.dp;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/9 5:30 PM
 *
 *
 * 机器人在mxn网格左上角到右下角的不同路径
 *
 *
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        // 令dp[i][j]是到达i，j最多路径
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[i][j] 依赖 dp[i-1][j] 和 dp[i][j-1]
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println("dp: " + Arrays.deepToString(dp));
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 2;
        int uniquePaths = uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
