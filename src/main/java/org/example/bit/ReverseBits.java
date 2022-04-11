package org.example.bit;

/**
 * @author xianpeng.xia
 * on 2022/4/11 2:36 PM
 */
public class ReverseBits {

    /**
     * @param n n
     * @return rev
     * 逐位颠倒
     * 思路
     *
     * 将 nn 视作一个长为 32 的二进制串，从低位往高位枚举 n 的每一位，将其倒序添加到翻转结果 rev 中。
     *
     * 代码实现中，每枚举一位就将 n 右移一位，这样当前 n 的最低位就是我们要枚举的比特位。当 n 为 0 时即可结束循环。
     *
     * 需要注意的是，在某些语言中，没有无符号整数类型，因此对 n 的右移操作应使用逻辑右移。
     *
     * 代码
     *
     * C++JavaGolangJavaScriptC
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-leetcode-solu-yhxz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
