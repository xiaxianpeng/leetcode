package org.example.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. 优势洗牌（田忌赛马）
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个长度相等的数组 nums1 和 nums2，
 * nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * 示例 1：
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * Created on 2024/11/12 16:53
 */
public class AdvantageCount {

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < nums2.length; i++) {
            maxHeap.add(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int[] result = new int[nums1.length];
        // 分别指向 nums1 的最小和最大元素
        int low = 0;
        int high = nums1.length - 1;
        while (!maxHeap.isEmpty()) {
            // 获取当前 nums2 中的最大元素及其索引
            int[] pair = maxHeap.poll();
            int index = pair[0];
            int val = pair[1];
            // 如果 nums1 中的最大元素可以占优，则用于占优
            if (nums1[high] > val) {
                result[index] = nums1[high];
                high--;
            } else {
                // 否则，用 nums1 中的最小元素与之对抗（为了保存较大的数值用于更大的 nums2 元素）
                result[index] = nums1[low];
                low++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        System.out.println(Arrays.toString(advantageCount(nums1, nums2)));
    }
}
