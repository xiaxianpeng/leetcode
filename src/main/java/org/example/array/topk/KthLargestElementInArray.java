package org.example.array.topk;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * Created on 2024/11/17 00:49
 */
public class KthLargestElementInArray {

    /**
     * 方法：找到数组中第 K 个最大的元素
     * 核心策略：使用最小堆维护数组中最大的 K 个元素，堆顶即为第 K 个最大元素。
     *
     * @param nums 输入的整数数组
     * @param k    需要找到的第 k 个最大元素
     * @return 数组中第 k 个最大的元素
     */
    public static int findKthLargest(int[] nums, int k) {
        // 创建一个最小堆，堆的大小保持为 k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 遍历数组中的每个元素
        for (int num : nums) {
            minHeap.offer(num);
            // 将元素加入堆
            // 如果堆的大小超过 k，则移除堆顶最小元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            System.out.println("当前堆: " + minHeap);
        }
        // 堆顶即为第 k 个最大元素
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2));
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4));
    }
}
