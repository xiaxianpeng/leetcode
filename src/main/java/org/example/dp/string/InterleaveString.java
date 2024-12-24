package org.example.dp.string;

/**
 * 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * Created on 2024/12/24 22:58
 */
public class InterleaveString {

    /**
     * 判断s3是否由s1和s2交错组成
     *
     * @param s1 第一个字符串
     * @param s2 第二个字符串
     * @param s3 目标字符串
     * @return 如果s3是由s1和s2交错组成的，返回true，否则返回false
     * 算法思路：dp
     * 1、创建一个dp[][],其中dp[i][j]表示s3的前i+j个字符是否可以由s1的前i个字符和s2个前j个字符交错组成
     * 2、初始化dp[0][0],因为空字符串可以由两个空字符串交错组成
     * 3、填充第一行和第一列
     * -- 第一行：仅使用s2的前j个字符来匹配s3的前j个字符
     * -- 第一列：仅使用s1的前i个字符来匹配s3的前i个字符
     * 4、填充剩余的dp数组
     * -- 对于每个dp[i][j],检查当前字符是否匹配s1和s2中的一个字符
     * -- 如果匹配，则更新dp[i][j]为true
     * 5、最终，dp[m][n]即为所求结果
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();
        if (m + n != t) {
            System.out.println("s1 和 s2 的长度之和不等于 s3 的长度，返回 false");
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        System.out.println("初始化 dp[0][0] = true");

        // 初始化第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            System.out.println("dp[" + i + "][0] = " + dp[i][0] + " （s1[" + (i - 1) + "] = '" + s1.charAt(i - 1) + "', s3[" + (i - 1) + "] = '" + s3.charAt(i - 1) + "')");
        }
        // 初始化第一行
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
            System.out.println("dp[0][" + j + "] = " + dp[0][j] + " （s2[" + (j - 1) + "] = '" + s2.charAt(j - 1) + "', s3[" + (j - 1) + "] = '" + s3.charAt(j - 1) + "')");
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int p = i + j - 1;
                // 检查是否可以从s1取字符
                if (s1.charAt(i - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                    System.out.println("dp[" + i + "][" + j + "] |= dp[" + (i - 1) + "][" + j + "] => " + dp[i][j]);
                }
                // 检查是否可以从s2取字符
                if (s2.charAt(j - 1) == s3.charAt(p)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                    System.out.println("dp[" + i + "][" + j + "] |= dp[" + i + "][" + (j - 1) + "] => " + dp[i][j]);
                }
            }
        }

        // 返回最终结果
        System.out.println("最终结果 dp[" + m + "][" + n + "] = " + dp[m][n]);
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1_1 = "aabcc";
        String s2_1 = "dbbca";
        String s3_1 = "aadbbcbcac";
        System.out.println(isInterleave(s1_1, s2_1, s3_1) + "\n");

        String s1_2 = "aabcc";
        String s2_2 = "dbbca";
        String s3_2 = "aadbbbaccc";
        System.out.println(isInterleave(s1_2, s2_2, s3_2) + "\n");

        String s1_3 = "";
        String s2_3 = "";
        String s3_3 = "";
        System.out.println(isInterleave(s1_3, s2_3, s3_3) + "\n");

    }

}
