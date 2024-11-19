package org.example.greedy;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * 墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。
 * 你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 10:43
 */
public class FindMinArrowShots {

    /**
     * 使用贪心算法解决最少弓箭问题。
     * 首先按气球的右边界进行排序，然后选择尽可能多的重叠气球进行爆破。
     *
     * @param points 气球的直径数组。
     * @return 引爆所有气球所需的最小弓箭数量。
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 按照气球的右边界进行排序
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        // 至少需要一支箭
        int arrows = 1;
        // 初始化当前箭的射出位置
        int end = points[0][1];

        // 遍历排序后的气球
        for (int i = 1; i < points.length; i++) {

            // 如果当前气球的起始位置大于当前箭的射出位置，说明需要新的箭
            if (points[i][0] > end) {
                // 增加箭的数量
                arrows++;
                // 更新当前箭的射出位置
                end = points[i][1];
            }
        }
        // 返回需要的弓箭数量
        return arrows;
    }

    public static void main(String[] args) {

        // 示例测试用例1
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points1)); // 输出: 2

        // 示例测试用例2
        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(findMinArrowShots(points2)); // 输出: 4

        // 示例测试用例3
        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(findMinArrowShots(points3)); // 输出: 2
    }
}
