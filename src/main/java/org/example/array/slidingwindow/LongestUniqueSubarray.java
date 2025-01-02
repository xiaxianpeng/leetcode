package org.example.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：最长无重复元素子数组的长度
 * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组。
 * Created on 2025/1/2 22:21
 */
public class LongestUniqueSubarray {

    /**
     * 最长无重复元素子数组的长度
     *
     * @param arr 输入的整数数组
     * @return 最长无重复元素子数组的长度
     * 算法思路:
     * 使用滑动窗口和HashMap的方法找到最长无重复元素的子数组长度
     * 通过记录每个元素的最新索引，快速跳过重复元素的位置
     * 从而高效的窗口移动和维护
     */
    public static int longestUniqueSubarrayLength(int[] arr) {
        // 使用HashMap记录元素及其最新的索引
        Map<Integer, Integer> window = new HashMap<>();
        // 初始化左指针
        int left = 0;
        // 初始化最大长度
        int maxLength = 0;

        // 遍历数组
        for (int right = 0; right < arr.length; right++) {
            int currentNum = arr[right];
            // 如果当前元素已经存在且索引不在左指针左侧
            if (window.containsKey(currentNum) && window.get(currentNum) >= left) {
                // 直接跳过重复元素的位置
                left = window.get(currentNum) + 1;
            }
            // 更新当前元素的最新索引
            window.put(currentNum, right);
            // 更新最长长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        System.out.println(longestUniqueSubarrayLength(arr1)); // 输出: 5

        int[] arr2 = {1, 3, 5, 3, 7, 9};
        System.out.println(longestUniqueSubarrayLength(arr2)); // 输出: 4

        int[] arr3 = {2, 2, 2, 2, 2};
        System.out.println(longestUniqueSubarrayLength(arr3)); // 输出: 1
    }
}
