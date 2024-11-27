package org.example.array.twopointers;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class SortColors {

    /**
     * 使用双指针和当前指针对数组进行原地排序
     * 思路：使用三个指针，分别对0、1、2进行排序调整。
     * 左指针放置0的正确位置，右指针放置2的正确位置。
     *
     * @param nums 输入的颜色数组
     */
    public static void sortColors(int[] nums) {

        // all in [0,left) = 0
        // all in [left,i) = 1
        // all in [right,len-1] = 2

        // 左指针，用于放置0
        int left = 0;
        // 右指针，用于放置2
        int right = nums.length - 1;
        // 当前指针，用于遍历数组
        int current = 0;
        while (current <= right) {
            if (nums[current] == 0) {
                // 如果当前元素是0，和左指针交换，然后移动左指针和当前指针
                swap(nums, current, left);
                left++;
                current++;
                System.out.println("Swapped 0 to left: " + Arrays.toString(nums));
            } else if (nums[current] == 2) {
                // 如果当前元素是2，和右指针交换，然后移动右指针
                swap(nums, current, right);
                right--;
                System.out.println("Swapped 2 to right: " + Arrays.toString(nums));
            } else {
                // 如果当前元素是1，直接移动当前指针
                current++;
                System.out.println("Moved past 1: " + Arrays.toString(nums));
            }
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums 数组
     * @param i    第一个元素的索引
     * @param j    第二个元素的索引
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println("Sorted result for nums1: " + Arrays.toString(nums1)); // 输出 [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        sortColors(nums2);
        System.out.println("Sorted result for nums2: " + Arrays.toString(nums2)); // 输出 [0, 1, 2]
    }
}
