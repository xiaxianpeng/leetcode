package org.example.twopointers.array;

import java.util.Arrays;

/**
 * 合并两个有序数组 nums1 和 nums2，返回一个新的合并数组。
 */
public class MergeTwoArray2 {

    /**
     * 合并两个有序数组 nums1 和 nums2，返回一个新的合并数组。
     *
     * @param nums1 第一个数组。
     * @param nums2 第二个数组。
     * @return 合并后的数组。
     * 算法思路：
     * 使用双指针，通过同时遍历两个数组，将较小的依次放入结果数组中
     * 这样可以在O(n)的时间复杂度内完成合并，n=两个数组的长度
     */
    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        // 获取两个数组的长度
        int len1 = nums1.length;
        int len2 = nums2.length;

        // 初始化新的数组来存储合并后的结果
        int[] ans = new int[nums1.length + nums2.length];

        // 初始化两个指针，分别指向nums1和nums2的起始位置
        int p1 = 0;
        int p2 = 0;

        // 初始化结果数组的指针
        int k = 0;

        // 使用双指针，遍历两个数组，直到一个数组遍历完
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] < nums2[p2]) {
                // 如果nums1的元素较小，将其放入结果数组中，并移动nums1的指针
                ans[k++] = nums1[p1++];
            } else {
                // 否则，将nums2的当前元素放入结果数组中，并移动nums1的指针
                ans[k++] = nums2[p2++];
            }
        }

        // 如果nums1还有剩余元素，将其全部放入结果数组
        while (p1 < len1) {
            ans[k++] = nums1[p1++];
        }

        // 如果nums2还有剩余元素，将其全部放入结果数组
        while (p2 < len2) {
            ans[k++] = nums2[p2++];
        }

        // 返回合并后的数组
        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        int[] result = mergeTwoArray(nums1, nums2);
        System.out.println(Arrays.toString(result));

        int[] nums3 = {};
        int[] nums4 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeTwoArray(nums3, nums4)));

        int[] nums5 = {4, 5, 6};
        int[] nums6 = {};
        System.out.println(Arrays.toString(mergeTwoArray(nums5, nums6)));

        int[] nums7 = {};
        int[] nums8 = {};
        System.out.println(Arrays.toString(mergeTwoArray(nums7, nums8)));

        int[] nums9 = {-3, -1, 2};
        int[] nums10 = {-2, 0, 3};
        System.out.println(Arrays.toString(mergeTwoArray(nums9, nums10)));
    }
}
