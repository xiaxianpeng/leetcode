package org.example.twopointers.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class ThreeSum {

    /**
     * 使用排序和双指针方法查找三数之和为 0 的所有三元组。
     * <p>
     * 算法思路：
     * 1. 首先对数组进行排序。
     * 2. 遍历数组，固定一个数 nums[i]，然后使用双指针查找满足条件的其他两个数。
     * 3. 跳过重复元素，避免重复结果。
     *
     * @param nums 输入的整数数组
     * @return 所有满足条件的三元组
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 特殊情况处理
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        // 1. 对数组进行排序，时间复杂度为 O(NlogN)。
        Arrays.sort(nums);
        System.out.println("Sorted nums: " + Arrays.toString(nums));

        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;

        // 2. 遍历排序后的数组
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于 0，三数之和不可能为 0，直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复的数字，避免重复三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针初始化
            int left = i + 1;// 左指针
            int right = len - 1;// 右指针

            // 3. 双指针查找满足条件的组合
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到一个符合条件的三元组
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    System.out.println("Found triplet: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    // 跳过重复的左指针元素
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    // 跳过重复的右指针元素
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;// 如果 sum < 0，说明左指针所指元素过小
                } else {
                    right--;// 如果 sum > 0，说明右指针所指元素过大
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " +Arrays.toString(nums));
        List<List<Integer>> results = threeSum(nums);
        System.out.println("Triplets: " + results);
    }
}
