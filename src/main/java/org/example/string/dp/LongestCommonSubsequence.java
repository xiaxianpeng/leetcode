package org.example.string.dp;

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
 * https://leetcode.cn/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 14:51
 */
public class LongestCommonSubsequence {

    /**
     * 使用动态规划求解最长公共子序列问题。
     * 定义dp数组，其中dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列长度。
     * 状态转移方程：
     * 如果text1[i] == text2[j], dp[i][j] = dp[i-1][j-1] + 1
     * 否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     *
     * @param text1 第一个字符串。
     * @param text2 第二个字符串。
     * @return 最长公共子序列的长度。
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // 定义dp数组，dp[i][j]表示text1前i个字符和text2前j个字符的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // 遍历每一个字符
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果text1的第i-1个字符等于text2的第j-1个字符
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 则取左上对角线的值加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 否则取左边和上边的最大值
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
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        // 示例测试用例1
        String text1_1 = "abcde";
        String text2_1 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1_1, text2_1)); // 输出: 3

        // 示例测试用例2
        String text1_2 = "abc";
        String text2_2 = "abc";
        System.out.println(solution.longestCommonSubsequence(text1_2, text2_2)); // 输出: 3

        // 示例测试用例3
        String text1_3 = "abc";
        String text2_3 = "def";
        System.out.println(solution.longestCommonSubsequence(text1_3, text2_3)); // 输出: 0
    }
}
