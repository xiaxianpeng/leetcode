package org.example.array;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement {

    /**
     * 摩尔投票法思路
     *
     * @param nums nums
     * @return 出现次数 大于 ⌊ n/2 ⌋ 的元素
     */
    public static int majorityElement(int[] nums) {
        // 1、初始化： 票数统计 votes = 0 ， 众数 x。
        // 众数
        int x = 0;
        // 票数
        int votes = 0;
        for (int num : nums) {
            // 2、当 票数 votes 等于 0 ，则假设当前数字 num 是众数。
            if (votes == 0) {
                x = num;
                // 当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1 。
                votes += num == x ? 1 : -1;
            }
        }
        //  返回众数x
        return x;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);

    }
}
