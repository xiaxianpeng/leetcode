package org.example.array.range;

import java.util.Arrays;

/**
 * 252. 会议室
 * 给定一个会议时间安排的数组 intervals ，
 * 每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 请你判断一个人是否能够参加这里面的全部会议。
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 * Created on 2024/12/14 20:40
 */
public class MeetingRoom {

    /**
     * 能否参加全部会议
     * 时间复杂度：O(n log n)，主要来自排序。
     * 空间复杂度：O(1)，不计入输入存储空间。
     *
     * @param intervals 会议时间安排的数组，每个元素为 [开始时间, 结束时间]
     * @return 如果能参加全部会议则返回 true，否则返回 false
     * 算法思想：
     * 首先根基会议开始时间对intervals排序
     * 然后通过线性扫描，检查前一个会议的结束时间是否晚于下一个会议的开始时间，
     * 如果发现冲突则返回false，否则在扫描完成后返回true
     * 时间复杂度：O(n log n)，主要来自排序。
     * 空间复杂度：O(1)，不计入输入存储空间。
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        // 校验
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // 根据会议开始时间进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println("Sorted: " + Arrays.deepToString(intervals));

        // 遍历已排序的会议数组，检查是否有冲突
        for (int i = 0; i < intervals.length - 1; i++) {
            // 如果当前会议结束时间 > 下一个会议开始时间，说明有冲突
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }

        // 若无冲突，返回true
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(intervals));

        int[][] intervals2 = new int[][]{{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals2));
    }
}
