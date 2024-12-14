package org.example.array.range;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. 会议室 II
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间[[s1, e1], [s2,e2], …](si < ei)，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排？
 * 示例1：
 * input： [[0, 30], [5, 10], [15, 20]]
 * output：2
 * 示例2：
 * input： [[7, 10], [2, 4]]
 * output：1
 * Created on 2024/12/14 21:17
 */
public class MeetingRoom2 {

    /**
     * 需要的会议室数量
     *
     * @param intervals 会议时间安排的数组，每个元素为 [开始时间, 结束时间]
     * @return 需要至少多少间会议室
     * 算法思路：
     * 使用最小堆解决会议室分配问题
     * 1、先按开始时间对会议进行排序
     * 2、使用一个最小堆，堆中存储会议的结束时间
     * 3、对排序后的会议逐个查看，当堆不为空且堆顶元素的结束时间小于等于当前会议的开始时间，
     * 表示可以复用该会议室，将堆顶元素弹出并替换为当前会议室的结束时间
     * 否则需要新开一间会议室，将当前会议的结束时间入堆
     * 最终堆的大小即为需要的会议室数量
     */
    public static int minMeetingRooms(int[][] intervals) {
        // 如果没有会议，直接返回0
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 1、对会议安排按开始时间排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println("排序后的会议安排: " + Arrays.deepToString(intervals));

        // 2、使用最小堆来存储会议的结束时间
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 将第一个会议的结束时间入堆
        System.out.println("将第一个会议结束时间 " + intervals[0][1] + " 加入堆");
        minHeap.offer(intervals[0][1]);

        // 3、从第二个会议开始逐个处理
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // 如果当前会议的开始时间大于或等于最早结束会议的结束时间
            // 则说明可以复用该会议室，把该结束时间弹出，然后替换为当前会议的结束时间
            if (start >= minHeap.peek()) {
                System.out.println("当前会议开始时间：" + start + " >= 堆顶结束时间：" + minHeap.peek() + "，复用会议室");
                minHeap.poll();
            } else {
                System.out.println("当前会议开始时间：" + start + " < 堆顶结束时间：" + minHeap.peek() + "，需要新增会议室");
            }

            // 将当前会议的结束时间加入堆中
            System.out.println("将当前会议结束时间 " + end + " 加入堆");
            minHeap.offer(end);
        }

        // 最终堆的大小就是需要的会议室数量
        System.out.println("需要的会议室数量为堆的大小：" + minHeap.size());
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("最少会议室数量：" + minMeetingRooms(intervals1));

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("最少会议室数量：" + minMeetingRooms(intervals2));
    }
}
