package org.example.array.binarysearch;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
 * 示例 3：
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * Created on 2024/11/27 18:17
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("Left: " + left + ", Mid: " + mid + ", Right: " + right);

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            System.out.println("Updated Left: " + left + ", Right: " + right);
        }

        // 返回最小值的位置
        System.out.println("Minimum value found at index: " + left);
        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum for nums1: " + findMin(nums1)); // 输出 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum for nums2: " + findMin(nums2)); // 输出 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Minimum for nums3: " + findMin(nums3)); // 输出 11
    }
}
