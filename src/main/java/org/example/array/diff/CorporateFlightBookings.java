package org.example.array.diff;

import org.example.util.ArrayUtil;

/**
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] ，
 * 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * Created on 2024/11/11 23:28
 */
public class CorporateFlightBookings {

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        // 创建差分数组
        int[] diff = new int[n];
        // 根据bookings更新差分数组
        for (int[] booking : bookings) {
            int first = booking[0] - 1;// 转换为从0开始的索引
            int last = booking[1] - 1;
            int seat = booking[2];
            // 在起始航班增加座位
            diff[first] += seat;
            if (last + 1 < n) {
                // 在结束航班的下一个航班减去座位
                diff[last + 1] -= seat;
            }
        }
        // 计算前缀和得到每个航班的座位总数
        int[] answer = new int[n];
        answer[0] = diff[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + diff[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] answer = corpFlightBookings(bookings, n);
        ArrayUtil.print(bookings);
        System.out.println("answer: ");
        ArrayUtil.print(answer);
    }
}
