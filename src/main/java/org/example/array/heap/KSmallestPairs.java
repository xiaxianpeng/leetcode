package org.example.array.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. 查找和最小的K对数字
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Created on 2024/12/26 18:29
 */
public class KSmallestPairs {

    /**
     * 查找和最小的K对数字
     *
     * @param nums1 第一个递增的整数数组
     * @param nums2 第二个递增的整数数组
     * @param k     数对数量
     * @return 返回最小和的数对数量
     * 算法思路：
     * 使用最小堆存储数对的索引，通过比较数对的和来维护堆的有序性
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 初始化结果列表
        List<List<Integer>> results = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 处理边界情况：如果任意数组为空，或k为0，返回列表
        if (length1 == 0 || length2 == 0 || k == 0) {
            return results;
        }

        // 最小堆，存储数对的索引，并根据数对的和进行排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> {
            int sum1 = nums1[pair1[0]] + nums2[pair1[1]];
            int sum2 = nums1[pair2[0]] + nums2[pair2[1]];
            return Integer.compare(sum1, sum2);
        });

        // 将nums1的前min(length1,k)，和nums2[0]组成数对，加入堆中
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        // 循环找到k个最小的数对
        while (k > 0 && !minHeap.isEmpty()) {
            // 从堆中取出当前最小和的数对索引
            int[] currentPair = minHeap.poll();
            // 将当前的数对添加到结果列表中
            List<Integer> result = new ArrayList<>();
            result.add(nums1[currentPair[0]]);
            result.add(nums2[currentPair[1]]);
            results.add(result);

            k--;

            // 如果当前数对的第二个元素不是nums2的最后一个元素，将下一个数对加到堆中
            if (currentPair[1] + 1 < nums2.length) {
                minHeap.offer(new int[]{currentPair[0], currentPair[1] + 1});
            }

        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;
        System.out.println(kSmallestPairs(nums1_1, nums2_1, k1));


        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 2;
        System.out.println(kSmallestPairs(nums1_2, nums2_2, k2));

        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 3;
        System.out.println(kSmallestPairs(nums1_3, nums2_3, k3));
    }
}
