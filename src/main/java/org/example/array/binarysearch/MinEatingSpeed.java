package org.example.array.binarysearch;

/**
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
 * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 示例 1：
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 */
public class MinEatingSpeed {

    /**
     * 计算最小吃香蕉速度
     *
     * @param piles 香蕉堆数组，每个元素代表一堆香蕉的数量
     * @param h     珂珂想要在 h 小时内吃完所有香蕉
     * @return 最小吃香蕉速度
     */
    public static int minEatingSpeed(int[] piles, int h) {
        // 设置二分查找的左右界，速度最小为1，最大为最大堆的数量
        int left = 1;
        int right = 10_0000_0000 + 1;// 使用一个较大的数作为初始右边界

        while (left < right) {
            // 计算中间速度
            int mid = left + (right - left) / 2;
            // 计算如果以mid速度吃香蕉需要的时间
            if (eatingTime(piles, mid) <= h) {
                // 如果时间不超过h，尝试更小的速度
                right = mid;
            } else {
                // 否则需要更快的速度
                left = mid + 1;
            }
        }
        // 返回最小速度
        return left;
    }

    /**
     * // 定义：速度为 speed 时，需要 eatingTime(speed) ⼩时吃完所有⾹蕉
     * // eatingTime(speed) 随着 speed 的增加单调递减
     */
    public static int eatingTime(int[] piles, int speed) {
        // 所需总时间
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            // 计算吃完当前堆所需时间
            hours += piles[i] / speed;
            if (piles[i] % speed > 0) {
                hours++;// 如果有剩余，仍需多花一小时
            }
        }
        return hours;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
