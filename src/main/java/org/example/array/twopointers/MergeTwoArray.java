package org.example.array.twopointers;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 */
public class MergeTwoArray {

    /**
     * 将 nums2 合并到 nums1 中，保持 nums1 的非递减顺序。
     *
     * @param nums1 第一个数组，长度为 m + n，前 m 个元素有效。
     * @param m     第一个数组的有效元素个数。
     * @param nums2 第二个数组，长度为 n。
     * @param n     第二个数组的有效元素个数。
     */
    public static void mergeTwoArray(int[] nums1, int m, int[] nums2, int n) {
        // 指向 nums1 数组的最后有效元素索引
        int i = m - 1;
        // 指向 nums2 数组的最后有效元素索引
        int j = n - 1;
        // 指向 nums1 数组的最后一个索引
        int k = m + n - 1;

        // 从后向前合并两个数组，确保不会覆盖 nums1 中的有效元素
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // 如果 nums2 中还有剩余元素，复制到 nums1 中
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeTwoArray(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));// 输出: [1, 2, 3, 4, 5, 6]

        int[] nums3 = {0, 0, 0};
        int[] nums4 = {1, 2, 3};
        mergeTwoArray(nums3, 0, nums4, 3);
        System.out.println(Arrays.toString(nums3)); // 输出: [1, 2, 3]
    }
}
