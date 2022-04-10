package org.example.bit;

/**
 * @author xianpeng.xia
 * on 2022/4/10 10:33 PM
 *
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = 0;
        //既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
        //一个数和 0 做 XOR 运算等于本身：a⊕0 = a
        //一个数和其本身做 XOR 运算等于 0：a⊕a = 0
        //XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
        //
        for (int num : nums) {
            ans ^= num;
            System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }
}
