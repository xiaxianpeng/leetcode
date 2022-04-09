package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/9 3:35 PM
 * 合并重叠区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 */
public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 对左端点排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 合并的区间
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            // 左右边界值
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {// 上一个区间的右边界比当前左边界小
                merged.add(intervals[i]);
            } else {// 上一个区间的右边界比当前右边界
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(intervals));
        int[][] mergeIntervals = mergeIntervals(intervals);
        System.out.println(Arrays.deepToString(mergeIntervals));
    }
}
