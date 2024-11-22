package org.example.twopointers.array;

/**
 * 42. 接雨水
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/13 18:41
 * ***
 * 理解积水的核心原则
 * 1、积水的高度由较低的边界决定：在一个凹槽中，积水的多少取决于两侧的边界高度。较低的边界决定了积水的上限。
 * 2、动态边界的更新：通过双指针法，我们动态地更新和比较两侧的边界，确保在遍历到每个位置时，能准确地计算其可能的积水量。
 */
public class Trap {

    /**
     * 使用双指针解决“接雨水”问题，不需要额外的空间。
     * 算法步骤：
     * 1. 使用两个指针 left 和 right，从数组的两端向中间移动。
     * 2. 维护两个变量 leftMax 和 rightMax 来记录当前指针左边和右边的最大高度。
     * 3. 当 left < right 时，比较 height[left] 和 height[right]：
     * - 如果 height[left] 小于或等于 height[right]：
     * - 此时，left 较低，故考虑左侧积水。
     * - 如果 height[left] 小于 leftMax，计算积水量为 leftMax - height[left]。
     * - 更新 leftMax 为当前看到的最大高度。
     * - 移动左指针以继续检查下一个位置。
     * - 如果 height[right] 小于 height[left]：
     * - 此时，right 较低，故考虑右侧积水。
     * - 如果 height[right] 小于 rightMax，计算积水量为 rightMax - height[right]。
     * - 更新 rightMax 为当前看到的最大高度。
     * - 移动右指针以继续检查下一个位置。
     * 4. 当两个指针相遇时，结束计算，返回总积水量。
     */
    public static int trap(int[] height) {
        // 特殊情况：数组为空或只有一个元素，无法积水
        if (height == null || height.length == 1) {
            return 0;
        }

        // 左右指针初始化
        int left = 0;
        int right = height.length - 1;

        // 保存左右两边的最大高度
        int leftMax = 0;
        int rightMax = 0;

        // 用于累加雨水总量
        int totalWater = 0;

        // 当左指针小于右指针时继续计算
        while (left < right) {

            if (height[left] < height[right]) {
                // 左侧较低时，考虑左侧的积水
                if (height[left] < leftMax) {
                    // 计算当前位置的积水量，并累加到总积水量
                    totalWater += leftMax - height[left];
                } else {
                    // 更新左侧最大高度
                    leftMax = Math.max(leftMax, height[left]);
                }
                // 移动左指针向右
                left++;
            } else {
                // 右侧较低时，考虑右侧的积水
                if (height[right] < rightMax) {
                    // 计算当前位置的积水量，并累加到总积水量
                    totalWater += rightMax - height[right];

                } else {
                    // 更新右侧最大高度
                    rightMax = Math.max(rightMax, height[right]);
                }
                // 移动右指针向左
                right--;
            }
        }
        // 返回计算的总积水量
        return totalWater;
    }

    public static void main(String[] args) {
        int[] testHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("能接的雨水量: " + trap(testHeights)); // 应该输出 6
    }
}
