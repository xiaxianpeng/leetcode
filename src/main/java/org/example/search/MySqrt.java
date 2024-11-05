package org.example.search;

/**
 * https://leetcode.cn/problems/sqrtx/description/
 * 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    /**
     * 由于 x 平方根的整数部分 ans 是满足 k * k ≤ x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。
     * 二分查找的下界为 0，上界可以粗略地设定为 x。
     * 在二分查找的每一步中，我们只需要比较中间元素 mid 的平方与 x 的大小关系，并通过比较的结果调整上下界的范围。
     * 由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 ans 后，也就不需要再去尝试 ans+1 了。
     */
    public static int mySqrt(int x) {
        int L = 0;
        int R = x;
        int ans = -1;
        while (L <= R) {
            int mid = L + (R - L) / 2;
            if (mid * mid <= x) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));
    }
}
