package org.example.array.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntervals {

    /**
     * 合并重叠的区间
     * 思路：首先将所有区间按照起始位置进行排序，然后依次合并重叠或相邻的区间。
     * 如果当前区间的起始点在上一个合并区间的终止点之前或者相等，则进行合并。
     *
     * @param intervals 输入的区间数组
     * @return 合并后的不重叠区间数组
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 对所有区间按照起始位置排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 合并的区间
        List<int[]> merged = new ArrayList<>();
        System.out.println("Sorted intervals: " + Arrays.deepToString(intervals));

        // 循环遍历每个区间
        for (int[] interval : intervals) {
            // 如果合并结果是空的，或者当前区间不重叠，直接添加
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
                System.out.println("Added new interval: " + Arrays.toString(interval));
            } else {
                // 否则，合并当前区间到结果中的最后一个区间
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
                System.out.println("Merged interval: " + Arrays.toString(merged.get(merged.size() - 1)));
            }
        }

        // 将结果转换为二维数组返回
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged1 = mergeIntervals(intervals1);
        System.out.println("Merged intervals for intervals1: " + Arrays.deepToString(merged1)); // 输出 [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] merged2 = mergeIntervals(intervals2);
        System.out.println("Merged intervals for intervals2: " + Arrays.deepToString(merged2)); // 输出 [[1, 5]]
    }
}
