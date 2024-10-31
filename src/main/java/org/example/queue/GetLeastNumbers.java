package org.example.queue;

import org.example.queue.structure.PriorityQueue;
import org.example.sort.SortUtil;

/**
 * @date 2021/02/24
 * @time 17:53
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {

    public static int[] solution(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.enqueue(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!priorityQueue.isEmpty() && arr[i] < priorityQueue.getFront()) {
                priorityQueue.dequeue();
                priorityQueue.enqueue(arr[i]);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.dequeue();
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
