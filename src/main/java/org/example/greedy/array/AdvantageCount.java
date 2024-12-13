package org.example.greedy.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. 优势洗牌（田忌赛马）
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

    /**
     * 优势洗牌的实现，最大化 nums1 对 nums2 的相对优势。
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return nums1 的重新排列结果
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        // 最大堆存储 nums2 的值和索引，按值降序排列
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (int i = 0; i < nums2.length; i++) {
            maxHeap.add(new int[]{i, nums2[i]});
        }
        // 对 nums1 升序排列
        Arrays.sort(nums1);
        int[] result = new int[nums1.length];

        // 双指针，分别指向nums1的最小和最大元素
        int left = 0;
        int right = nums1.length - 1;

        // 遍历堆，匹配 nums2 的最大值
        while (!maxHeap.isEmpty()) {
            // 获取 nums2 中的最大值及其索引
            int[] pair = maxHeap.poll();
            int index = pair[0];
            int value = pair[1];

            // 贪心策略：如果 nums1[right] 能击败它，
            if (nums1[right] > value) {
                result[index] = nums1[right];
                right--;
            } else {
                // 否则，用 nums1[left] 消耗掉value
                result[index] = nums1[left];
                left++;
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
