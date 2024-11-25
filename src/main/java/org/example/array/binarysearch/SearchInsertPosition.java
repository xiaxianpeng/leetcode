package org.example.array.binarysearch;


/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 */
public class SearchInsertPosition {

    /**
     * 使用二分查找找到目标值在数组中的位置或插入点
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 目标值在数组中的位置
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;// 防止溢出
            if (nums[mid] == target) {
                return mid;// 找到目标值，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1;// 在右半部分搜索
            } else {
                right = mid - 1;// 在左半部分搜索
            }
        }
        return left;// 返回插入位置
    }

    public static void main(String[] args) {
        System.out.println("index:" + searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
