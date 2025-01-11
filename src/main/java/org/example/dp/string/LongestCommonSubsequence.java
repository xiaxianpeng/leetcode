package org.example.dp.string;

/**
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * 示例 1：
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 * Created on 2024/11/19 14:51
 */
public class LongestCommonSubsequence {

    /**
     * 使用动态规划求解最长公共子序列问题。
     *
     * @param text1 第一个字符串。
     * @param text2 第二个字符串。
     * @return 最长公共子序列的长度。
     * 算法思路：
     * 构建一个二维dp数组，其中dp[i][j]表示text1前i个字符与text2前j个字符的最长公共子序列长度;
     * 如果当前字符相同，则dp[i][j] = dp[i-1][j-1]+1;
     * 否则dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 定义dp数组，dp[i][j]表示text1前i个字符和text2前j个字符的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // 遍历每一个字符,填充DP数组
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                // 比较当前字符是否相同
                if (c1 == c2) {
                    // 则取左上对角线的值加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相同，取左边或上边的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                // 打印当前dp状态
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }

        // 返回最后一个位置的值，即最长公共子序列的长度
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace")); // 输出: 3
        System.out.println(longestCommonSubsequence("abc", "abc")); // 输出: 3
        System.out.println(longestCommonSubsequence("abc", "def")); // 输出: 0
    }
}
