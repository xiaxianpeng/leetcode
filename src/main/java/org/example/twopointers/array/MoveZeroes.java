package org.example.twopointers.array;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/18 00:26
 */
public class MoveZeroes {
    /**
     * 移动零：使用双指针法，遍历数组，将非零元素交换到前面。
     * 1. 使用一个指针 i 遍历数组。
     * 2. 使用另一个指针 j 记录非零元素的位置。
     * 3. 每当遇到非零元素，就将其与位置 j 交换。
     * 4. 最终所有非零元素会被移到数组前面，零元素会移动到数组的末尾。
     */
    public static void moveZeroes(int[] nums) {
        // 非零元素的插入位置
        int j = 0;
        // 遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不为0，进行交换
            if (nums[i] != 0) {
                // 交换 nums[i] 和 nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // 更新非零元素插入位置
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // 输出：[1, 3, 12, 0, 0]

        int[] nums2 = {0};
        moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2)); // 输出：[0]
    }
}
