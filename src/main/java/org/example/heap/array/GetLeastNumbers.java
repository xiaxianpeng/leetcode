package org.example.heap.array;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 * 提示
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class GetLeastNumbers {

    public static int[] getLeastNumbers(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        // 需要在最大堆中存k个最小元素
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            // 比较num[i]与堆顶元素，如果小于堆顶元素，就插入堆
            Integer max = maxHeap.peek();
            if (nums[i] < max) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        // 遍历pq
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));//[2, 1]
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));//[4, 3, 2, 1]
    }
}
