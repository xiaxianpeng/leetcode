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
 */
public class Trap {

    /**
     * 使用双指针法解决“接雨水”问题，我们可以不需要额外的空间来分别存储每个位置的左侧和右侧最大高度。
     * 相反，我们只需要两个变量来跟踪左侧和右侧的最大高度，并根据这些最大值来计算每个位置上方的积水。
     * 算法思想如下：
     * 双指针初始化：我们设置两个指针 left 和 right 分别指向数组的起始位置和末尾位置。
     * 同样，我们设置两个变量 leftMax 和 rightMax 来追踪 left 和 right 指针所指位置左侧和右侧的最大高度。
     * 指针移动：当 left < right 时，我们比较 height[left] 和 height[right]。
     * 根据两者的比较结果，我们移动 left 或 right 指针。
     * 计算积水：如果 height[left] 小于 leftMax，我们可以确定 left 位置可以积水 leftMax - height[left]，
     * 因为 rightMax 是更大的，并且是左侧积水的限制因素。否则，我们更新 leftMax。
     * 反之，如果 height[right] 小于 rightMax，我们可以确定 right 位置可以积水 rightMax - height[right]，
     * 否则我们更新 rightMax。
     * 更新指针：如果 height[left] 小于 height[right]，我们移动 left 指针。否则，我们移动 right 指针。
     * 结束条件：当 left 和 right 相遇时，我们完成了对积水量的计算。
     */
    public static int trap(int[] height) {
        // 如果输入数组为空或长度为0，则返回0，因为没有地方可以积水
        if (height == null || height.length == 1) {
            return 0;
        }

        // 初始化左指针
        int left = 0;
        // 初始化右指针
        int right = height.length - 1;
        // 初始化左侧最高高度
        int leftMax = 0;
        // 初始化右侧最高高度
        int rightMax = 0;
        // 初始化总积水量
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // 判断当前左指针指向的高度是否小于左侧最高高度
                if (height[left] >= leftMax) {
                    // 更新左侧最高高度
                    leftMax = height[left];
                } else {
                    // 计算当前位置的积水量，并累加到总积水量
                    totalWater += leftMax - height[left];
                }
                // 移动左指针
                left++;
            } else {
                // 判断当前右指针指向的高度是否小于右侧最高高度
                if (height[right] >= rightMax) {
                    // 更新右侧最高高度
                    rightMax = height[right];
                } else {
                    // 计算当前位置的积水量，并累加到总积水量
                    totalWater += rightMax - height[right];
                }
                // 移动右指针
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
