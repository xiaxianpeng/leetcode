package org.example.array.dp;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 链接：https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/13 18:41
 */
public class Trap {

    /**
     * 计算雨水的积存量
     * 算法思路：
     * 1. 创建两个数组 leftMax 和 rightMax 分别存储每个位置左侧和右侧的最大高度。
     * 2. 使用动态规划填充这两个数组。
     * 3. 根据左右最大高度计算每个位置能积存的雨水量。
     *
     * @param height 高度图数组
     * @return 积存的雨水量
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
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("能接的雨水量: " + trap(height1)); // 应该输出 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("能接的雨水量: " + trap(height2)); // 应该输出 9
    }
}
