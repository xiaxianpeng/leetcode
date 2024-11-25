package org.example.dp.array;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * Created on 2024/11/19 12:49
 */
public class HouseRobber {

    /**
     * 使用动态规划解决打家劫舍问题。
     * 对于每间房屋，决定偷或不偷，通过状态转移方程更新最高金额。
     *
     * @param nums 每个房屋存放的金额数组。
     * @return 能偷窃到的最高金额。
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] 表示偷到第 i 间房屋为止的最高金额
        int[] dp = new int[nums.length + 1];
        // 只有一间房屋时，最大金额即为该房屋的金额
        dp[0] = nums[0];
        // 两间房屋时，选择金额较大的房屋
        dp[1] = Math.max(nums[0], nums[1]);

        // 遍历每间房屋，更新偷到当前位置的最大金额
        for (int i = 2; i < nums.length; i++) {
            // 决定偷或不偷第 i 间房屋
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            // 打印当前状态
            System.out.println("House " + (i + 1) + ": Max money = " + dp[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        // 示例测试用例1
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 输出: 4

        // 示例测试用例2
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 输出: 12
    }
}