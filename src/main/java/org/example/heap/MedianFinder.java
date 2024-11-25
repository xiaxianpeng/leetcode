package org.example.heap;

import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * 示例 1：
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * Created on 2024/11/25 16:59
 */
public class MedianFinder {

    // 最大堆，用于存储较小的一半
    private PriorityQueue<Integer> maxHeap;
    // 最小堆，用于存储较大的一半
    private PriorityQueue<Integer> minHeap;

    /**
     * 初始化 MedianFinder 对象。
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    /**
     * 将数据流中的整数 num 添加到数据结构中。
     *
     * @param num 要添加的整数
     */
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        // 如果最小堆比最大堆多一个以上的元素，移动一个元素到最大堆
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        System.out.println("MaxHeap: " + maxHeap);
        System.out.println("MinHeap: " + minHeap);
    }

    /**
     * 返回到目前为止所有元素的中位数。
     *
     * @return 中位数
     */
    public double findMedian() {
        // 如果两个堆的大小相同，中位数是两个堆顶的平均值
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.size() + minHeap.peek()) / 2.0;
        }
        // 否则，中位数是最大堆的堆顶
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // 输出: 1.5

        medianFinder.addNum(3);    // arr = [1, 2, 3]
        System.out.println(medianFinder.findMedian()); // 输出: 2.0
    }
}
