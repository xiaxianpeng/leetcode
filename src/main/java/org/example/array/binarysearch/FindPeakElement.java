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
     * 使用二分查找法找到峰值元素的索引。
     * 在每次迭代中，检查中间元素及其与相邻元素的关系，然后选择合适的子区间进行查找。
     *
     * @param nums 输入的整数数组。
     * @return 峰值元素的索引。
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {// 如果中间元素小于右边元素，则峰值在右边
                left = mid + 1;
            } else {// 否则，峰值在左边或当前元素就是峰值
                right = mid;
            }
        }
        // 当left == right时，已经找到一个峰值
        return left;
    }

    public static void main(String[] args) {
        // 示例测试用例1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak Index: " + findPeakElement(nums1)); // 输出: 2

        // 示例测试用例2
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Index: " + findPeakElement(nums2)); // 输出: 1 或 5
    }
}
