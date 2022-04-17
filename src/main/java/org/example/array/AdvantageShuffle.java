package org.example.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author xianpeng.xia
 * on 2022/4/17 5:22 PM
 *
 * 870. 优势洗牌
 * 给定两个大小相等的数组 nums1 和 nums2，
 * nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 */
public class AdvantageShuffle {

    public static int[] advantageShuffle(int[] nums1, int[] nums2) {
        // nums2降序排序
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < nums2.length; i++) {
            maxPQ.offer(new int[]{i, nums2[i]});
        }
        // 给nums1生序排序
        Arrays.sort(nums1);

        int n = nums1.length;
        int[] ans = new int[n];
        // nums1[left]是最小值，nums1[right]是最大值
        int left = 0, right = n - 1;

        while (!maxPQ.isEmpty()) {
            int[] pair = maxPQ.poll();
            //maxVal是nums2中的最大值，i是对应的索引
            int i = pair[0], maxVal = pair[1];
            if (maxVal < nums1[right]) {
                // 如果nums1[right] 能胜过maxVal，就自己上
                ans[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下
                ans[i] = nums1[left];
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15}, nums2 = new int[]{1, 10, 4, 11};
        int[] advantageShuffle = advantageShuffle(nums1, nums2);
        System.out.println(Arrays.toString(advantageShuffle));
    }
}
