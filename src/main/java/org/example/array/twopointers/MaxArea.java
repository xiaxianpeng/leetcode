package org.example.array.twopointers;

/**
 * 11. 盛最多水的容器
 * 给你 n 个⾮负整数 a1，a2，...，an，
 * 其中每个数代表坐标中的⼀个点 (i, ai)。
 * 在坐标内画 n 条垂直 线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的⽔。
 * 输⼊：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输⼊数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳⽔（表示为蓝⾊部分）的最⼤值为 49。
 */
public class MaxArea {

    /**
     * 计算容器可以容纳的最大水量。
     *
     * @param height 每条垂直线的高度数组
     * @return 最大的水量
     */
    public static int maxArea(int[] height) {
        // 初始化左右指针，分别指向数组的两端
        int left = 0;
        int right = height.length - 1;

        // 用于存储当前最大水量
        int maxArea = 0;

        // 使用双指针法收缩区间，直到两指针相遇
        while (left < right) {
            // 计算当前区域的水量
            int curArea = Math.min(height[left], height[right]) * (right - left);

            // 更新最大水量
            maxArea = Math.max(maxArea, curArea);

            // 双指针策略：移动较短的那一边，以尝试找到更大的容器
            if (height[left] < height[right]) {
                left++;//左指针右移
            } else {
                right--;//右指针左移
            }
        }

        // 返回最大的水量
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
