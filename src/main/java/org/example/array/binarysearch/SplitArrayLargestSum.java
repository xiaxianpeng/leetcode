package org.example.array.binarysearch;

/**
 * 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 k ，
 * 你需要将这个数组分成 k 个非空的连续子数组，
 * 使得这 k 个子数组各自和的最大值 最小。
 * 返回分割后最小的和的最大值。
 * 子数组 是数组中连续的部份。
 * 示例 1：
 * 输入：nums = [7,2,5,10,8], k = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。
 * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * 示例 2：
 * 输入：nums = [1,2,3,4,5], k = 2
 * 输出：9
 * 示例 3：
 * 输入：nums = [1,4,4], k = 3
 * 输出：4
 * Created on 2024/11/12 20:44
 */
public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int k) {
        // 单个子数组和的最小可能值（数组中的最大元素）
        long max = 0;
        // 所有子数组和的最大可能值（数组元素之和）
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 二分查找
        // 最小可能值
        long left = max;
        // 最大可能值
        long right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 如果当前的mid值可以实现分割，尝试更小的值
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 当left等于right时，我们找到了最优解
        return (int) left;
    }

    private static boolean canSplit(int[] nums, int k, long maxSumLimit) {
        // 需要的子数组数量
        int count = 1;
        // 当前子数组的和
        int currentSum = 0;
        for (int num : nums) {
            // 如果加上当前数会超过限制，那么需要开始一个新的子数组
            if (currentSum + num > maxSumLimit) {
                // 增加子数组的数量
                count++;
                // 重置当前子数组的和
                currentSum = 0;
            }
            // 累加当前子数组的和
            currentSum += num;
            // 如果子数组的数量大于k，说明无法在这个最大和限制下分割成k个子数组
            if (count > k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 示例 1
        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("示例 1 - 分割数组的最大值：" + splitArray(nums1, k1)); // 输出应该是 18

        // 示例 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("示例 2 - 分割数组的最大值：" + splitArray(nums2, k2)); // 输出应该是 9

        // 示例 3
        int[] nums3 = {1, 4, 4};
        int k3 = 3;
        System.out.println("示例 3 - 分割数组的最大值：" + splitArray(nums3, k3)); // 输出应该是 4
    }
}
