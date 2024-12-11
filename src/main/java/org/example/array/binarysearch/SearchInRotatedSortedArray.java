package org.example.array.binarysearch;

/**
 * 33. 搜索旋转排序数组
 * 中等
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class SearchInRotatedSortedArray {

    /**
     * 算法思路：
     * 使用二分查找
     * 1、设置左右指针left，right
     * 2、找到中点mid，并判断中心落在旋转数组的左半部分还是右半部分
     * -如果左半部分有序nums[left]<=nums[mid]，若target在left和mid之间，则缩小范围到左半部分，否则到右半部分
     * -否则，右半部分有序nums[mid]<nums[left],若target在mid和right之间，则缩小范围到右半部分，否则到左半部分
     * 3、不断缩小范围，直到left>right则未找到目标值，返回-1
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值下标
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 使用二分查找
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检查是否找到目标值
            if (nums[mid] == target) {
                return mid;
            }

            // 判断哪一半是有序的
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    // 目标值在左半部分范围内
                    right = mid - 1;
                } else {
                    // 目标值不在左半部分范围内，转向右半部分
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    // 目标值在右半部分范围内
                    left = mid - 1;
                } else {
                    // 目标值不在右半部分范围内，转向左半部分
                    right = mid - 1;
                }
            }
        }

        // 未找到目标值，返回-1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int index = search(nums, 7);
        System.out.println(index);
    }

}
