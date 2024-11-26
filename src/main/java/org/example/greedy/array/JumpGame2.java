package org.example.greedy.array;

/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * Created on 2024/11/25 22:16
 */
public class JumpGame2 {

    /**
     * 找到到达最后一个索引的最小跳跃次数。
     * 核心思路：使用贪心算法，通过迭代更新当前跳跃所能到达的最远范围，
     * 并在每次到达当前范围的末尾时增加跳跃次数。
     *
     * @param nums 非负整数数组
     * @return 到达最后一个索引的最小跳跃次数
     */
    public static int jump(int[] nums) {
        // 用于记录跳跃次数
        int jumps = 0;
        // 当前跳跃能够到达的最远位置
        int currentJumpEnd = 0;
        // 在当前跳跃过程中能到达的最远位置
        int maxReach = 0;

        // 遍历数组，最后一个位置不需要再跳
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前能到达的最远位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 当到达当前跳跃的末尾时，需要进行一次新的跳跃
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = maxReach;// 更新新的跳跃的结束位置

                // 如果已经可以到达或超过最后一个位置，跳出循环
                if (currentJumpEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }
}
