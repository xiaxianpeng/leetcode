package org.example.queue;

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
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * Created on 2024/11/15 11:41
 * 链接：https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
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

        // 结果数组的大小
        int[] ans = new int[nums.length - k + 1];
        // 单调队列，存储索引，并保持索引对应的元素值单调递减
        Deque<Integer> deque = new LinkedList<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            System.out.println("i=" + i + ",当前滑动窗口的索引范围: " + (i - k + 1) + " 到 " + i);

            // 移除不在滑动窗口范围内的索引
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                System.out.println("移除队列头部（不在窗口内的索引）: " + deque.peek());
                deque.pollFirst();
            }
            /**
             当我们遍历数组并向队列中添加新元素的索引时，我们必须维持队列的 单调递减 属性。
             这意味着在队列中，一个元素的前面不会有比它小的元素。为了维护这个属性，我们需要执行以下步骤：
             1、查看队列尾部元素：我们查看队列尾部的索引对应的元素值，如果它比当前元素小，
             那么这个尾部元素不可能再成为任何后续窗口的最大值（因为当前元素和所有后续元素都会在它之前被考虑）。
             2、移除队列尾部元素：我们从队列的尾部移除所有比当前元素小的索引。
             我们重复这个过程直到队列为空（没有更多元素可以移除）或者队列尾部的索引对应的元素大于等于当前元素（队列恢复为单调递减）。
             3、添加新元素的索引：最后，我们将当前元素的索引添加到队列的尾部。
             如此一来，队列仍然保持了单调递减的顺序，且队列头部的索引对应的元素是窗口内的最大值。
             通过这种方式，我们确保了队列中的第一个元素始终是窗口内的最大值，而如果最大值离开窗口，
             我们可以通过简单地弹出队列的头部元素来更新最大值，而无需遍历整个窗口。
             同时，由于我们存储的是索引，我们也可以轻松地判断一个元素是否还在窗口内。
             */

            // 从队列尾部移除所有比当前遍历到的元素值小的索引，这是为了维护队列的单调递减性质。
            // 当这些元素离开队列后，队列的尾部将是小于或等于当前元素值的最大元素，从而确保队列头部始终是当前窗口内的最大值。
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                System.out.println("移除队列尾部（小于当前元素的索引）: " + deque.peekLast());
                deque.pollLast();
            }

            // 将当前索引添加到队列尾部
            deque.offer(i);

            // 打印队列操作后的状态
            System.out.print("队列中的索引：");
            for (int index : deque) {
                System.out.print(index + " ");
            }
            System.out.println();

            // 当前索引 i 大于等于 k - 1 时，滑动窗口的最大值就是队列的第一个元素所对应的值
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peek()];
                System.out.println("滑动窗口的最大值：" + nums[deque.peek()]);
            }
            System.out.println("----------");
        }
        return ans;
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
