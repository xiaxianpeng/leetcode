package org.example.dp.array;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * Created on 2024/11/18 20:58
 */
public class CountBits {

    /**
     * 动态规划解法：
     * dp[i] = dp[i >> 1] + (i & 1)
     * 1. `i >> 1` 表示将 i 右移一位，相当于去掉最低位，复用已经计算的 dp[i >> 1]。
     * 2. `i & 1` 用来判断 i 的最低位是否为 1，如果是 1，则加 1，否则不加。
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // dp[i] 通过之前计算的结果递推
            dp[i] = dp[i >> 1] + i & 1;
            // 打印每个数字的计算过程
            System.out.println("i: " + i + ", Binary: " + Integer.toBinaryString(i) + ", dp[" + i + "]: " + dp[i]);
        }
        return dp;
    }

    public static void main(String[] args) {
        // 示例 1
        int n1 = 2;
        System.out.println("n = " + n1 + ", Result: " + java.util.Arrays.toString(countBits(n1)));

        // 示例 2
        int n2 = 5;
        System.out.println("n = " + n2 + ", Result: " + java.util.Arrays.toString(countBits(n2)));
    }
}
