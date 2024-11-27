package org.example.string.dp;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 */
public class MinDistance {

    /**
     * 计算将 word1 转换为 word2 所需的最少操作数。
     * 核心思路：动态规划。
     * 定义一个二维数组 dp，其中 dp[i][j] 表示将 word1 的前 i 个字符转换为 word2 的前 j 个字符的最少操作数。
     * 状态转移方程：
     * - 如果 word1[i-1] == word2[j-1]，则 dp[i][j] = dp[i-1][j-1]
     * - 否则，dp[i][j] = 1 + min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])
     * 其中，dp[i-1][j-1] 表示替换字符，dp[i][j-1] 表示插入字符，dp[i-1][j] 表示删除字符。
     *
     * @param word1 第一个单词
     * @param word2 第二个单词
     * @return 最少操作数
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;// word1 的前 i 个字符转换为空字符串需要删除 i 次
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;// 空字符串转换为 word2 的前 j 个字符需要插入 j 次
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果当前字符相同，不需要额外操作
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 否则取三种操作中的最小值
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],// 替换
                            Math.min(dp[i][j - 1],// 插入
                                    dp[i - 1][j])); // 删除
                }
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println("Edit distance between 'horse' and 'ros': " + minDistance("horse", "ros")); // 输出: 3
        System.out.println("Edit distance between 'intention' and 'execution': " + minDistance("intention", "execution")); // 输出: 5
    }
}
