package org.example.heap;

import java.util.PriorityQueue;

/**
 * @author xianpeng.xia
 * on 2021/3/20 10:52 上午
 * <p>
 * 寻找无序数组的中位数
 */
public class FindNoSortedArrayMedianNum {


    public static double findMedianNum(int[] nums) {
        // 大顶堆中存储前半部分数据，小顶堆中存储后半部分数据，且小顶堆中的数据都大于大顶堆中的数据。
        // 如果有 n 个数据，n 是偶数，我们从小到大排序，
        // 那前 n2个数据存储在大顶堆中，后 n2 个数据存储在小顶堆中。
        // 这样，大顶堆中的堆顶元素就是我们要找的中位数。
        // 如果 n 是奇数，情况是类似的，大顶堆就存储 n2+1个数据，小顶堆中就存储 n2个数据。

        // 若母节点的值恒小于等于子节点的值，此堆称为最小堆（min heap）；
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 若母节点的值恒大于等于子节点的值，此堆称为最大堆（max heap）；
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int k = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (maxHeap.size() == 0 || nums[i] <= maxHeap.peek()) {
                maxHeap.add(nums[i]);
                if (maxHeap.size() > k) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(nums[i]);
                if (maxHeap.size() < k) {
                    maxHeap.add(minHeap.poll());
                }
            }

        }
        return nums.length % 2 == 0 ? (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // {1, 23, 5, 2, 23, 2, 4, 142};
        System.out.println(findMedianNum(nums));
    }
}
