package org.example.topk;

import java.util.PriorityQueue;

import org.example.util.ArrayUtil;

/**
 * LCR 059. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * 示例：
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 */
public class KthLargest {

    /**
     * 可以使用一个大小为 k 的优先队列来存储前 k 大的元素，
     * 其中优先队列的队头为队列中最小的元素，也就是第 k 大的元素。
     * 在单次插入的操作中，我们首先将元素 val 加入到优先队列中。
     * 如果此时优先队列的大小大于 k，我们需要将优先队列的队头元素弹出，以保证优先队列的大小为 k。
     * 链接：https://leetcode.cn/problems/jBjn9C/solutions/1041946/shu-ju-liu-de-di-k-da-shu-zhi-by-leetcod-11n3/
     */
    public static int[] kthLargest(int k, int[] nums) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int num : nums) {
            // 优先队列的队头为队列中最小的元素，也就是第 k 大的元素。
            add(pq, k, num);
        }
        // result
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    public static int add(PriorityQueue<Integer> pq, int k, int num) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        int k = 3;
        int[] ans = kthLargest(k, nums);
        ArrayUtil.print(ans);
    }
}
