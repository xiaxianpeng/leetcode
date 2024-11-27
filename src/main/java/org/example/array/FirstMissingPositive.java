package org.example.array;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * Created on 2024/11/27 16:57
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        System.out.println("Original array: " + Arrays.toString(nums));

        // 将每个正数放置到对应的索引位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                System.out.println("Swapped positions to place number: " + Arrays.toString(nums));
            }
        }

        // 通过检查哪个位置的索引不匹配，找到缺失的第一个正数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                System.out.println("First missing positive is: " + (i + 1));
                return i + 1;
            }
        }

        // 如果所有位置都正确，则缺失的数是 n + 1
        System.out.println("All positions correct, first missing positive is: " + (n + 1));
        return n + 1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 0};
        System.out.println("First missing positive for nums1: " + firstMissingPositive(nums1)); // 输出 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println("First missing positive for nums2: " + firstMissingPositive(nums2)); // 输出 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("First missing positive for nums3: " + firstMissingPositive(nums3)); // 输出 1
    }
}
