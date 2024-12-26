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
     */
    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int cur;
        while (p1 < len1 || p2 < len2) {
            if (p1 == len1) { //转向nums2
                cur = nums2[p2++];
            } else if (p2 == len2) { //转向nums1
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) { // nums1[p1++]
                cur = nums1[p1++];
            } else { // nums2[p2++]
                cur = nums2[p2++];
            }
            ans[p1 + p2 - 1] = cur;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        int[] result = mergeTwoArray(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
