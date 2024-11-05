package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/11 10:46 AM
 * <p>
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
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

    /**
     * @param nums nums
     * @return 出现次数 大于 ⌊ n/3 ⌋ 的元素
     * <p>
     * 229. 求众数 II
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,2,3]
     * 输出：[3]
     * 示例 2：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     * 示例 3：
     * <p>
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
