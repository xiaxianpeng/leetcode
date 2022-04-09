package org.example.recursion;

/**
 * @author xianpeng.xia
 * on 2022/4/9 1:30 PM
 *
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * https://leetcode-cn.com/problems/powx-n/
 */
public class Pow {

    public static double pow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        return n < 0 ? 1 / powHelper(x, Math.abs(n)) : powHelper(x, Math.abs(n));
    }

    public static double powHelper(double x, int n) {
        if (n == 1) {
            return x;
        }

        // 根据n的奇偶性递归
        if (n % 2 != 0) {//n为奇数
            double half = powHelper(x, n / 2);
            return half * half * x;
        } else {//n为偶数
            double half = powHelper(x, n / 2);
            return half * half;
        }
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double pow = pow(x, n);
        System.out.println(pow);
    }
}
