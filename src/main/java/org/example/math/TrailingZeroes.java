package org.example.math;

/**
 * @author xianpeng.xia
 * on 2022/4/11 12:22 PM
 *
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 */
public class TrailingZeroes {

    /**
     * @param n n
     * 经典统计质因数运用题
     *
     * 对于任意一个 n!n! 而言，其尾随零的个数取决于展开式中 10 的个数，
     * 而 10 可由质因数 2 * 5 而来，因此 n! 的尾随零个数为展开式中各项分解质因数后「2 的数量」和「5 的数量」中的较小值
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/by-ac_oier-1y6w/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        int i = trailingZeroes(5);
        System.out.println(i);
    }
}
