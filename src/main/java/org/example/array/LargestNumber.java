package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/11 12:42 PM
 *
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class LargestNumber {

    /**
     * @param nums nums
     * 贪心算法
     * https://leetcode-cn.com/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
     */
    public static String largestNumber(int[] nums) {
        int len = nums.length;
        String[] ss = new String[len];

        for (int i = 0; i < len; i++) {
            ss[i] = nums[i] + "";
        }
        // 排序
        Arrays.sort(ss, (a, b) -> {
            String ab = a + b, ba = b + a;
            return ba.compareTo(ab);
        });

        // 最大数（包含0）
        StringBuffer sb = new StringBuffer();
        for (String s : ss) {
            sb.append(s);
        }

        // 去掉头是0的
        int length = sb.length();
        int k = 0;
        while (k < length - 1 && sb.charAt(k) == '0') {
            k++;
        }
        return sb.substring(k);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 2};
        System.out.println(largestNumber(nums));
    }
}
