package org.example.greedy.array;

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
     * 判断是否能够跳跃到最后一个下标
     *
     * @param nums 输入的数组，nums[i] 表示当前位置能跳跃的最大步数。
     * @return 如果能到达最后一个下标，返回 true；否则返回 false。
     * 算法思路：
     * - 使用贪心算法，维护一个变量 maxReach，表示目前能跳到的最远位置。
     * - 遍历数组，更新 maxReach 并判断是否能到达最后一个下标。
     * - 如果 maxReach 在遍历过程中超过或等于数组的最后一个位置，则返回 true。
     * - 如果无法更新 maxReach，说明无法到达最后一个下标，返回 false。
     */
    public static boolean canJump(int[] nums) {
        // 初始化最远可达位置
        int maxReach = 0;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 当前位置不可达，返回false
            if (i > maxReach) {
                return false;
            }

            // 更新最大可达位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 如果最远位置超过或等于最后一个下标，返回true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        // 遍历结束后，仍未能到达最后一个下标，返回false
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump: " + canJump(nums1)); // 输出: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump: " + canJump(nums2)); // 输出: false
    }
}
