package org.example.math;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），
 * 并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * Created on 2024/12/28 23:35
 */
public class IntegerBreak {

    /**
     * 计算整数拆分后的最大乘积
     *
     * @param n 给定的正整数
     * @return 拆分后的最大乘积
     * 算法思路：
     * 使用贪心算法，将整数尽可能多地拆分为3，因为3的乘积能最大化
     * 当剩余的数为4时，拆分为2+2，以避免1的出现影响乘积
     */
    public static int integerBreak(int n) {
        // 特殊情况处理
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        // 初始化乘积
        int product = 1;

        // 当n>4，尽可能多地拆分为3
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        // 最后剩下的数可能是2，3，4
        product *= n;

        return product;
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
