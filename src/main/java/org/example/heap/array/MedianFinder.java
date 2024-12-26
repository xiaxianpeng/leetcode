package org.example.heap.array;

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

    /**
     * 最大堆，存储较小的一半数据，堆顶为该半区的最大值
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 最小堆，存储较大的一半数据，堆顶为该半区的最小值
     */
    private PriorityQueue<Integer> minHeap;

    /**
     * 使用两个堆来高效维护数据流的中位数
     * 1、maxHeap 用来存储当前数据流中较小的一半元素，堆顶是该部分最大的元素
     * 2、minHeap 用来存储当前数据量中较大的一半元素，堆顶是该部分最小的元素
     * ***
     * 保持两个堆的特性：
     * - 数据要分为两半，一半在maxHeap，一半在minHeap，使得maxHeap中所有元素均小于等于minHeap中的所有元素
     * - 两堆的大小相差不超过1
     * 这样：
     * - 当元素总个数为奇数时，中位数就是元素更多的那一堆的堆顶，即maxHeap
     * - 当元素总个数为偶数时，中位数是两个堆顶元素的平均值
     */
    public MedianFinder() {
        // 初始化 MedianFinder 对象。
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    /**
     * 将数据流中的整数 num 添加到数据结构中。
     * 算法思路：
     * 1、首先将新元素放入maxHeap，这样可以确保新元素先与较小半区比较
     * 2、然后将maxHeap中的最大值弹出并放入minHeap，以分离出较大的一半元素。
     * 此时，minHeap中堆顶是较大半区的最小值，maxHeap中全部元素小于等于minHeap中的元素
     * 3、若此时minHeap的大小超过maxHeap(意味着较大半区过多),则将minHeap的最小值弹出返回maxHeap
     * 再度平衡两堆大小，使两者数量差不超过1
     * ***
     * 通过以上操作，每次插入后两个堆仍保持有序和近似平衡，从而为O(1)时间获取中位数打好基础
     *
     * @param num 要添加的整数
     */
    public void addNum(int num) {
        // 1、将新元素放入maxHeap
        maxHeap.offer(num);
        // 2、将maxHeap中的最大值（堆顶）转移到minHeap
        // 这样minHeap一定存储当前较大的一半数据
        minHeap.offer(maxHeap.poll());

        // 3、如果minHeap大小比maxHeap大，说明较大半区过多
        // 将minHeap中的最小值（堆顶）弹出放入maxHeap，平衡两堆大小
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        System.out.println("MaxHeap: " + maxHeap);
        System.out.println("MinHeap: " + minHeap);
    }

    /**
     * 返回到目前为止所有元素的中位数。
     * 如果两个堆大小相同，中位数是两堆堆顶的平均值
     * 如果堆大小不相同，中位数为元素更多的堆的堆顶
     *
     * @return 当前数据量的中位数
     */
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // 偶数个元素时，中位数是两堆堆顶元素的平均值
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            //奇数个元素时，中位数在maxHeap（因为maxHeap始终>=minHeap的元素数量）
            return maxHeap.peek();
        }
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
