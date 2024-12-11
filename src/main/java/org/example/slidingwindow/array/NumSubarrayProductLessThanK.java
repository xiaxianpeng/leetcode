package org.example.slidingwindow.array;

/**
 * LCR 009. 乘积小于 K 的子数组
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 */
public class NumSubarrayProductLessThanK {

    /**
     * 算法思路：
     * 使用滑动窗口（Sliding Window）技术来高效地遍历数组并计算乘积。
     * 1. 初始化两个指针 left 和 right，分别表示窗口的左右边界。
     * 2. 初始化变量 product 来记录当前窗口内元素的乘积，初始值为1。
     * 3. 初始化计数器 count 为0，用于记录符合条件的子数组数量。
     * 4. 遍历数组，移动右指针：
     * a. 将当前元素 nums[right] 加入乘积中，即 product *= nums[right]。
     * b. 如果 product >= k，则移动左指针，逐步缩小窗口，同时将 nums[left] 从乘积中移除，
     * 即 product /= nums[left]，直到 product < k 或 left > right。
     * c. 此时，窗口内的所有子数组（从 left 到 right）的乘积都小于 k，因此将 (right - left + 1) 加到计数器 count 中。
     * 5. 遍历结束后，返回计数器 count。
     * 这种方法的时间复杂度为 O(n)，因为每个元素最多被访问两次（一次被右指针访问，一次被左指针访问）。
     *
     * @param nums 正整数数组
     * @param k    目标乘积
     * @return 乘积小于 k 的连续子数组的个数
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 特殊情况处理：如果 k <= 1，则不存在乘积小于 k 的正整数子数组
        if (k <= 1) {
            return 0;
        }
        // 记录符合条件的子数组数量
        int count = 0;
        // 当前窗口元素乘积
        int product = 1;
        // 左指针初始化
        int left = 0;
        // 遍历数组，右指针0->n-1
        for (int right = 0; right < nums.length; right++) {
            // 将当前元素加入乘积
            product *= nums[right];
            // 如果乘积>=k,移动左指针，缩小窗口
            while (product >= k && left <= right) {
                product /= nums[left];// 将左指针指向的元素移出乘积
                left++;// 左指针右移
            }
            // 此时，窗口的所有子数组的乘积都小于k
            int windowsSize = right - left + 1;
            // 累加符合条件的子数组数量
            count += windowsSize;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
