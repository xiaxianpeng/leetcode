package org.example.heap.array;

import java.util.PriorityQueue;

/**
 * 寻找无序数组的中位数
 */
public class FindNoSortedArrayMedianNum {


    /**
     * 寻找无序数组的中位数
     *
     * @param nums 无序数组
     * @return 中位数
     * 算法思路:
     * 大顶堆中存储前半部分数据，小顶堆中存储后半部分数据，且小顶堆中的数据都大于大顶堆中的数据。
     * 如果有 n 个数据，n 是偶数，我们从小到大排序，
     * 那前 n2个数据存储在大顶堆中，后 n2 个数据存储在小顶堆中。
     * 这样，大顶堆中的堆顶元素就是我们要找的中位数。
     * 如果 n 是奇数，情况是类似的，大顶堆就存储 n2+1个数据，小顶堆中就存储 n2个数据。
     */
    public static double findMedianNum(int[] nums) {
        // 最大堆存前半部分数据，最小堆存后半部分部分
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 遍历
        for (int i = 0; i < nums.length; i++) {
            // 判断与maxHeap堆顶大小，如果小于加入到maxHeap
            // 保持minHeap存最多k个元素
            maxHeap.offer(nums[i]);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        return nums.length % 2 == 0 ? ((double)maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findMedianNum(new int[]{1, 2, 3, 4, 5}));//3.0
        System.out.println(findMedianNum(new int[]{1, 2, 3, 4}));//2.5
        System.out.println(findMedianNum(new int[]{1, 23, 5, 2, 23, 2, 4, 142}));
    }
}
