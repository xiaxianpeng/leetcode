package org.example.array;

import java.util.ArrayList;
import java.util.List;

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
     * @return 出现次数 大于 ⌊ n/2 ⌋ 的元素
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

    /**
     * @param nums nums
     * @return 出现次数 大于 ⌊ n/3 ⌋ 的元素
     *
     * 229. 求众数 II
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：[3,2,3]
     * 输出：[3]
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：[1]
     * 示例 3：
     *
     * 输入：[1,1,1,3,3,2,2,2]
     * 输出：[1,2]
     */
    public static List<Integer> majorityElements(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;

        for (int num : nums) {

            if (c1 != 0 && a == num) {
                c1++;
            } else if (c2 != 0 && b == num) {
                c2++;
            } else if (c1 == 0 && ++c1 >= 0) {
                a = num;
            } else if (c2 == 0 && ++c2 >= 0) {
                b = num;
            } else {
                c1--;
                c2--;
            }

        }

        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (a == num) {
                c1++;
            } else if (b == num) {
                c2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) {
            ans.add(a);
        }
        if (c2 > n / 3) {
            ans.add(b);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);

        nums = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> majorityElements = majorityElements(nums);
        System.out.println(majorityElements);

    }
}
