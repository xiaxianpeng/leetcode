package org.example.queue;

import java.util.PriorityQueue;

/**
 * @date 2021/02/24
 * @time 18:35
 * <p>
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class GetKthLargest {

    public static int solution(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!pq.isEmpty() && arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int num = solution(arr, 2);
        System.out.println(num);
    }
}
