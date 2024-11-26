package org.example.array.greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
 * 示例 1:
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 10:04
 */
public class NonOverlappingIntervals {

    /**
     * 使用贪心算法解决无重叠区间问题。
     * 先按区间的结束时间排序，然后选择最多不重叠的区间。
     *
     * @param intervals 区间数组。
     * @return 需要移除的最小区间数量。
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按照区间的结束时间进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前区间的开始时间小于上一个区间的结束时间，说明有重叠
            if (intervals[i][0] < end) {
                // 需要移除当前区间
                count++;
            } else {
                // 更新当前区间的结束时间为没有重叠的区间的结束时间
                end = intervals[i][1];
            }
        }
        // 返回需要移除的区间数量
        return count;
    }
}
