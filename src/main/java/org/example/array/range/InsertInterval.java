package org.example.array.range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，
 * 其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * 在 intervals 中插入区间 newInterval，
 * 使得 intervals 依然按照 starti 升序排列，
 * 且区间之间不重叠（如果有必要的话，可以合并区间）。
 * 返回插入之后的 intervals。
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * Created on 2024/12/6 11:17
 */
public class InsertInterval {

    /**
     * 插入区间并合并重叠区间
     * 核心思路：
     * 1. 遍历 intervals 中的区间，分别处理不重叠区间和重叠区间。
     * 2. 对于不重叠区间，直接加入结果列表。
     * 3. 对于重叠区间，合并 newInterval 与重叠区间。
     * 4. 处理完成后返回结果列表。
     *
     * @param intervals   已排序的区间列表
     * @param newInterval 新插入的区间
     * @return 合并后的区间列表
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. 将所有不重叠的区间加入结果列表
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. 合并所有与 newInterval 重叠的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // 更新 newInterval 的起始点和结束点
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // 合并后的 newInterval 加入结果列表
        result.add(newInterval);

        // 3. 将剩余不重叠的区间加入结果列表
        while (i < n) {
            result.add(intervals[i]); // 直接加入结果
            i++;
        }

        // 将 ArrayList 转为二维数组返回
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = insert(intervals1, newInterval1);
        System.out.println("插入区间后的结果1：" + Arrays.deepToString(result1));

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = insert(intervals2, newInterval2);
        System.out.println("插入区间后的结果2：" + Arrays.deepToString(result2));
    }
}
