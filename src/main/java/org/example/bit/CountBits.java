package org.example.bit;

import java.util.Arrays;

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
     * <*>
     * 1. `i >> 1`：将 `i` 右移一位，相当于 `i` 除以2并去掉最低位。
     * - 这相当于计算 `i` 不考虑最低位时的1的个数。
     * - 例如，对 `5`（二进制 `101`），`5 >> 1` 得到 `2`（二进制 `10`）。
     * 已知 `dp[2]` 为 `1`，即 `10` 中有一个 `1`。
     * <*>
     * 2. `i & 1`：检查 `i` 的最低位是否为1。
     * - 用按位与运算获取 `i` 的最低位。
     * - 如果最低位是 `1`，那么 `i` 比 `i >> 1` 多一个 `1`。
     * - 例如，`5 & 1` 等于 `1`，表示 `5` 的最低位是 `1`。
     * <*>
     * 通过将这两部分相加，我们有效地利用了之前计算的结果，
     * 从而快速计算出 `i` 的1的个数。
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // dp[i] 通过之前计算的结果递推
            dp[i] = dp[i >> 1] + (i & 1);
            // 打印每个数字的计算过程
            System.out.println("i: " + i + ", Binary: " + Integer.toBinaryString(i) + ", dp[" + i + "]: " + dp[i]);
        }
        return dp;
    }

    public static void main(String[] args) {
        int n1 = 2;
        System.out.println("n = " + n1 + ", Result: " + Arrays.toString(countBits(n1)));

        int n2 = 5;
        System.out.println("n = " + n2 + ", Result: " + Arrays.toString(countBits(n2)));
    }
}
