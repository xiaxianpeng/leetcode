package org.example.twopointers.array;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 * 给定一个整数数组 nums 和一个整数 k。
 * 每一步操作中，从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回可以对数组执行的最大操作数。
 * 示例 1：
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 示例 2：
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * Created on 2024/11/18 09:38
 */
public class MaxNumberOfKSumPairs {
    /**
     * 使用双指针法，在排序数组中查找和为 k 的数对。
     * 核心思路：
     * 1. 对数组进行排序。
     * 2. 使用双指针，初始化 left 指向开头，right 指向结尾。
     * 3. 如果 nums[left] + nums[right] == k，则记录一次操作，并移动两个指针。
     * 4. 如果和小于 k，则移动 left 指针以增大和。
     * 5. 如果和大于 k，则移动 right 指针以减小和。
     * 时间复杂度：O(n log n)，排序需要 O(n log n)，双指针遍历需要 O(n)。
     * 空间复杂度：O(1)，只使用了常数额外空间。
     */
    public static int maxOperations(int[] nums, int k) {
        // 先对数组进行排序
        Arrays.sort(nums);
        // 记录操作数
        int operations = 0;
        // 初始化双指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                // 找到一个数对
                operations++;
                // 左指针右移
                left++;
                // 右指针左移
                right--;
            } else if (sum < k) {
                // 和小于 k，左指针右移以增大和
                left++;
            } else {
                // 和大于 k，右指针左移以减小和
                right--;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5)); // 输出：2
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // 输出：1
    }

}
