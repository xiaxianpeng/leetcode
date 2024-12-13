package org.example.array.binarysearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class SearchRange {

    /**
     * 在排序数组中查找目标值的第一个和最后一个位置。
     *
     * @param nums   按非递减顺序排列的整数数组
     * @param target 要查找的目标值
     * @return 包含目标值在数组中起始位置和结束位置的数组。如果目标值不存在，返回 [-1, -1]
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};// 数组为空，特殊处理
        }
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    /**
     * 使用二分查找找到目标值的第一个位置（左边界）。
     *
     * @param nums   按非递减顺序排列的整数数组
     * @param target 要查找的目标值
     * @return 目标值的第一个位置（索引），如果不存在则返回 -1
     */
    private static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 二分查找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;//在右半部分查找
            } else {
                right = mid - 1;//缩小到左半部分
            }
        }
        // 检查左边界是否越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 使用二分查找找到目标值的最后一个位置（右边界）。
     *
     * @param nums   按非递减顺序排列的整数数组
     * @param target 要查找的目标值
     * @return 目标值的最后一个位置（索引），如果不存在则返回 -1
     */
    private static int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 二分查找右边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;//在左半部分查找
            } else {
                left = mid + 1;//缩小到右半部分
            }
        }
        // 检查右边界是否越界
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));//[3,4]
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));//[-1,-1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));//[-1,-1]
    }
}
