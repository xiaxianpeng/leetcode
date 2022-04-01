package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/1 7:58 PM
 *
 * 珂珂喜欢吃⾹蕉。这⾥有 N 堆⾹蕉，第 i 堆中有 piles[i] 根⾹蕉。
 * 警卫已经离开了，将在 H ⼩时后回来。 珂珂可以决定她吃⾹蕉的速度 K（单位：根/⼩时）。
 * 每个⼩时，她将会选择⼀堆⾹蕉，从中吃掉 K 根。如果 这堆⾹蕉少于 K 根，她将吃掉这堆的所有⾹蕉，然后这⼀⼩时内不会再吃更多的⾹蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的⾹蕉。计算她可以在 H ⼩时内吃掉所有⾹蕉的最⼩速度 K（K 为整数）。
 * 示例 1：输⼊：piles = [3,6,7,11], H = 8
 * 输出：4
 * 示例 2： 输⼊：piles = [30,11,23,4,20], H = 5
 * 输出：30
 * 示例 3： 输⼊：piles = [30,11,23,4,20], H = 6
 * 输出：23
 */
public class MinEatingSpeed {

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 10_0000_0000 + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * // 定义：速度为 x 时，需要 f(x) ⼩时吃完所有⾹蕉
     * // f(x) 随着 x 的增加单调递减
     */
    public static int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
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
