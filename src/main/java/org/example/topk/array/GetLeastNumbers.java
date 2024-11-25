package org.example.topk.array;

import java.util.PriorityQueue;

import org.example.sort.SortUtil;

/**
 * 从1000w个数中找10个取出10个最小的数,并按顺序打印
 */
public class GetLeastNumbers {

    public static int[] solution(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (!maxHeap.isEmpty() && arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] result = solution(arr, k);
        SortUtil.print(result);
    }
}
