package org.example.array.binarysearch;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，
 * 在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * 链接：https://leetcode.cn/problems/find-peak-element/?envType=study-plan-v2&envId=leetcode-75
 * Created on 2024/11/19 16:09
 */
public class FindPeakElement {

    /**
     * 算法思路：
     * 使用二分查找：O(log n)
     * 1、设置左右指针，left=0，right=nums.length-1
     * 2、计算中间位置mid
     * 3、比较nums[mid]与nums[mid+1]：
     * - nums[mid]<nums[mid+1],mid到mid+1呈上升趋势，则峰值在右半部分，因此移动left=mid+1
     * - 否则，峰值在左半部分(包括mid)，移动right=mid
     * 4、当left=right，该位置就是峰值位置
     *
     * @param nums 输入的整数数组。
     * @return 峰值元素的索引。
     */
    public static int findPeakElement(int[] nums) {
        // 初始化左右指针
        int left = 0;
        int right = nums.length - 1;

        // 使用二分查找逼近峰值位置
        while (left < right) {
            // 取中点
            int mid = left + (right - left) / 2;

            // 判断中点与其右侧元素的关系
            if (nums[mid] < nums[mid + 1]) {
                // 如果中点值小于右侧值，则峰值必在右侧
                left = mid + 1;
            } else {
                // 否则，峰值在左侧(包含mid)
                right = mid;
            }
        }

        // 循环结束后，left==right，指向峰值
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index: " + findPeakElement(nums1)); // 输出: 2

        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index: " + findPeakElement(nums2)); // 输出: 1 或 5
    }
}
