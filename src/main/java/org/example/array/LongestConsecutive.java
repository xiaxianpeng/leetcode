package org.example.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xianpeng.xia
 * on 2022/4/10 7:37 PM
 *
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        //  数字set
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestConsecutive = 0;
        for (Integer num : numSet) {
            // 从x为起点尝试，x+1,x+2,⋯是否存在
            if (!numSet.contains(num - 1)) {
                int curNum = num;
                int curStreak = 1;
                while (numSet.contains(curNum + 1)) {
                    curNum += 1;
                    curStreak += 1;
                }
                longestConsecutive = Math.max(longestConsecutive, curStreak);
            }
        }
        return longestConsecutive;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int longestConsecutive = longestConsecutive(nums);
        System.out.println(longestConsecutive);
    }
}
