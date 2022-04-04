package org.example.heap;

import java.util.PriorityQueue;

/**
 * @author xianpeng.xia
 * on 2021/3/20 10:52 上午
 *
 * 寻找无序数组的中位数
 */
public class FindNoSortedArrayMedianNum {


    public static double findMedianNum(int[] nums) {

        // 若母节点的值恒小于等于子节点的值，此堆称为最小堆（min heap）；
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        // 若母节点的值恒大于等于子节点的值，此堆称为最大堆（max heap）；
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int len = nums.length;
        int k = len % 2 == 0 ? len / 2 : len / 2 + 1;

        for (int i = 0; i < len; i++) {
            if (maxPQ.size() == 0 || nums[i] <= maxPQ.peek()) {
                maxPQ.add(nums[i]);
                if (maxPQ.size() > k) {
                    minPQ.add(maxPQ.poll());
                }
            } else {
                minPQ.add(nums[i]);
                if (maxPQ.size() < k) {
                    maxPQ.add(minPQ.poll());
                }
            }
        }
        //
        return len % 2 == 0 ? (maxPQ.peek() + minPQ.peek()) / 2.0 : maxPQ.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; //{1,23,5,2,23,2,4,142};
        System.out.println(findMedianNum(nums));
    }
}
