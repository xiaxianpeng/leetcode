package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/11 10:46 AM
 *
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement {

    /**
     * 摩尔投票法思路
     *
     * @param nums nums
     * @return 众数
     */
    public static int majorityElement(int[] nums) {
        // 候选人candNum初始化为nums[0], 票数count = 1;
        int candNum = nums[0], count = 1;
        for (int num : nums) {
            if (candNum == num) {
                count++;
            } else if (count-- == 0) {
                candNum = num;
                count = 1;
            }
        }
        return candNum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
    }
}
