package org.example.array.topk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author xianpeng.xia
 * on 2022/4/12 11:49 AM
 *
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你返回其中出现频率前 k 高的元素。
 * 你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class TopKFrequent {

    /**
     * @param nums nums
     * @param k k
     * 1、首先遍历整个数组，并使用哈希表记录每个数字出现的次数，并形成一个「出现次数数组」。
     * 2、建立一个小顶堆，然后遍历「出现次数数组」：
     * *1）如果堆的元素个数小于 k，就可以直接插入堆中。
     * *2）如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。如果堆顶更大，
     * ****说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；否则，就弹出堆顶，并将当前值插入堆中。
     * 3、遍历完成后，堆中的元素就代表了「出现次数数组」中前 k 大的值。
     *
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
     * *
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // num-> 出现次数
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[]的第一个元素代表数组的值，第二个元素代表出现的次数
        // 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Entry<Integer, Integer> entry : occurrences.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(nums));
        int[] topKFrequent = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(topKFrequent));
    }
}
