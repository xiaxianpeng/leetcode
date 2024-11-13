package org.example.twopointers.array;

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

    public static int maxArea(int[] height) {
        // 初始化左指针
        int left = 0;
        // 初始化右指针
        int right = height.length - 1;
        // 用于存储最大面积
        int maxArea = 0;
        while (left < right) {
            // 贪心的策略 // 计算当前左右指针界定的容器能够存储的水量，[left,height]之间的面积
            int curArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, curArea);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
