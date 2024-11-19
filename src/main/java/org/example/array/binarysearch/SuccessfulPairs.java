package org.example.array.binarysearch;

import java.util.Arrays;

/**
 * 2300. 咒语和药水的成功对数
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，
 * 其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * 示例 1：
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * 示例 2：
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * 链接：https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 16:27
 */
public class SuccessfulPairs {

    /**
     * 使用排序和二分查找计算每个咒语的成功组合数。
     * 对药水数组进行排序，然后对每个咒语使用二分查找找到成功组合的起始位置。
     *
     * @param spells  咒语数组。
     * @param potions 药水数组。
     * @param success 成功所需的能量强度。
     * @return 每个咒语成功组合的药水数量。
     */
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        // 对药水数组进行排序
        Arrays.sort(potions);

        // 使用二分查找找到成功组合的起始位置
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if ((long) spell * potions[mid] >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 计算成功组合的数量
            result[i] = m - left;
            System.out.println("Spell " + spell + ": Number of successful pairs = " + result[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        // 示例测试用例1
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        int success1 = 7;
        System.out.println(Arrays.toString(successfulPairs(spells1, potions1, success1))); // 输出: [4, 0, 3]

        // 示例测试用例2
        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        int success2 = 16;
        System.out.println(Arrays.toString(successfulPairs(spells2, potions2, success2))); // 输出: [2, 0, 2]
    }
}
