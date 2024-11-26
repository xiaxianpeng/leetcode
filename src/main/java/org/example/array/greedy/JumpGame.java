package org.example.array.greedy;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * Created on 2024/11/25 21:23
 */
public class JumpGame {

    /**
     * 判断是否能够到达最后一个下标。
     * 核心思路：使用贪心算法，维护一个变量来记录当前能到达的最远位置。
     * 如果在遍历过程中，当前位置超过了最远位置，则无法到达最后一个下标。
     *
     * @param nums 非负整数数组
     * @return 能否到达最后一个下标
     */
    public static boolean canJump(int[] nums) {
        // 记录当前能到达的最远位置
        int maxReach = 0;

        // 遍历数组的每个位置
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置 i 超出了 maxReach，说明我们无法到达 i
            if (i > maxReach) {
                return false;
            }

            // 从当前位置 i 出发，能跳跃到的最远位置。
            maxReach = Math.max(maxReach, i + nums[i]);

            // maxReach 已经到达或超过最后一个位置的索引，说明我们可以到达最后一个位置
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump: " + canJump(nums1)); // 输出: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump: " + canJump(nums2)); // 输出: false
    }
}
