package org.example.dp;

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
 */
public class Trap {

    /**
     * 动态规划（DP）的方法来解决“接雨水”问题
     * ***
     * 检查数组是否为空：如果输入数组是空的或者长度为0，那么直接返回0，因为没有柱子可以积水。
     * 构造辅助数组：创建两个辅助数组 leftMax 和 rightMax。
     * leftMax 数组存储从左向右遍历时，每个位置左侧（包括当前位置）的最高柱子高度。
     * rightMax 数组存储从右向左遍历时，每个位置右侧（包括当前位置）的最高柱子高度。
     * 填充 leftMax 数组：从左向右遍历输入数组 height，
     * 计算并填充 leftMax 数组，使得 leftMax[i] 是 height[0] 到 height[i] 中的最大值。
     * 填充 rightMax 数组：从右向左遍历输入数组 height，
     * 计算并填充 rightMax 数组，使得 rightMax[i] 是 height[i] 到 height[height.length - 1] 中的最大值。
     * 计算总积水量：遍历 height 数组，对于每个位置 i，计算在此位置上方可以积水的量，
     * 通过找到 leftMax[i] 和 rightMax[i] 中较小的一个，然后减去 height[i] 本身的高度。
     * 这个差值如果是正数，表示当前位置可以积水；累加这个差值到 totalWater 中即可得到最终的总积水量。
     * 返回结果：返回 totalWater，这就是下雨后所有柱子上方可以积累的雨水总量。
     */
    public static int trap(int[] height) {
        // 如果输入数组为空或长度为0，则返回0，因为没有地方可以积水
        if (height == null || height.length == 0) {
            return 0;
        }

        // 创建一个数组来存储从左到右每个位置的左侧最高高度
        int[] leftMax = new int[height.length];
        // 创建一个数组来存储从右到左每个位置的右侧最高高度
        int[] rightMax = new int[height.length];

        // 初始化数组的第一个元素 // 左边的第一个位置的左侧最高高度就是它自己
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            // 遍历数组，计算每个位置的左侧最高高度：
            // 它要么是当前位置的高度，要么是该位置左侧所有位置的最大高度
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 初始化数组的最后一个元素 // 右边的最后一个位置的右侧最高高度就是它自己
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            // 从右向左遍历数组，计算每个位置的右侧最高高度：
            // 它要么是当前位置的高度，要么是该位置右侧所有位置的最大高度
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 计算积水量
        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            // 遍历数组，使用左侧和右侧最高高度的最小值来决定当前位置的积水量，
            // 然后从积水量中减去当前位置的实际高度
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] testHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("能接的雨水量: " + trap(testHeights)); // 应该输出 6
    }
}
