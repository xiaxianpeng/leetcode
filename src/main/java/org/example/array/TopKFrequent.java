package org.example.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopKFrequent {

    /**
     * 方法：找出数组中前 K 个高频元素
     * 核心策略：使用哈希表统计每个元素的频率，然后使用最小堆来找到频率最高的 K 个元素。
     *
     * @param nums 输入的整数数组
     * @param k    需要返回的高频元素数量
     * @return 出现频率前 K 高的元素列表
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的频率
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("元素频率统计: " + frequencyMap);

        // 使用最小堆找出频率最高的 K 个元素
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            // 保持堆的大小为 K
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            System.out.println("当前堆: " + minHeap);
        }

        // 取出堆中的元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }
        System.out.println("前 " + k + " 个高频元素: " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
