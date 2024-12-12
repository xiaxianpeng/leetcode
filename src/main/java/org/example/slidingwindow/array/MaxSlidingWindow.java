package org.example.slidingwindow.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                  最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * Created on 2024/11/15 11:41
 */
public class MaxSlidingWindow {

    /**
     * 算法思路如下：
     * 1、创建一个双端队列 deque 来维持一个 k 大小的滑动窗口内的元素索引，并确保这些索引对应的元素值是单调递减的。
     * 2、创建一个数组 ans 用于存储每个滑动窗口的最大值。
     * 3、遍历数组 nums：
     * 首先，从队列的头部移除不在滑动窗口范围内的索引。
     * 然后，从队列的尾部移除所有小于当前元素 nums[i] 的索引，因为它们不可能是最大值。
     * 将当前遍历到的索引加入到队列尾部。
     * 如果遍历到的索引大于等于 k-1（滑动窗口已经形成），则将队列头部索引对应的元素值加入到 ans 数组中。
     * 4、遍历完成后，返回 ans 数组作为结果。
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 单调队列，存储索引，单调递减
        Deque<Integer> deque = new LinkedList<>();

        // 1、初始化窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();//删除尾部较小的值
            }
            deque.offerLast(i);// 添加当前索引
        }
        result[0] = nums[deque.peekFirst()];

        // 2、从第K个元素开始滑动窗口
        for (int i = k; i < nums.length; i++) {

            // 移除不在窗口内的索引
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除队列中小于当前值的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加当前索引
            deque.offerLast(i);

            // 当前窗口的最大值
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        // [3,3,5,5,6,7]
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));

        int[] nums2 = {1};
        int k2 = 1;
        // [1]
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2)));
    }
}
