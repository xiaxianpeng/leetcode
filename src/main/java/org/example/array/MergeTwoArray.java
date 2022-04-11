package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/9 9:46 PM
 * 合并两个有序数组
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1, len2 = n - 1;
        int len = m + n - 1;

        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }


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
        int[] nums1 = new int[]{1, 2, 4, 5, 6, 8};
        int[] nums2 = new int[]{2, 8, 34, 56};
        int[] ans = mergeTwoArray(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}
