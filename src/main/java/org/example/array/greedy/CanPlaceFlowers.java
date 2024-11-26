package org.example.array.greedy;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，
 * 其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 * 示例 1：
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * Created on 2024/11/17 23:55
 */
public class CanPlaceFlowers {

    /**
     * 算法思路：
     * 遍历整个 flowerbed 数组，依次检查每个位置是否可以种花。
     * 如果当前位置没有花（即为 0），且前后都没有花（前后也为 0 或者是边界位置），
     * 就可以种一朵花。
     * 每次成功种花后，增加 count，直到 count >= n 为止，返回 true。
     * 如果遍历完数组后仍未种够 n 朵花，则返回 false。
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // 如果当前位置没有花且前后位置也没有花
            if (flowerbed[i] == 0 // 当前位置没有花
                    && (i == 0 || flowerbed[i - 1] == 0)// 前一位置没有花
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {// 后一位置没有花
                // 在当前位置种花
                flowerbed[i] = 1;
                // 增加种花数量
                count++;
                // 如果种的花数达到了 n，返回 true
                if (count >= n) {
                    return true;
                }
            }
        }
        // 如果遍历完成后还未达到 n，返回 false
        return false;
    }

    public static void main(String[] args) {
        // 测试样例1
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // 输出：true
        // 测试样例2
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // 输出：false
        // 测试样例3
        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0, 0}, 3)); // 输出：true
        // 测试样例4
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 0)); // 输出：true
    }
}
