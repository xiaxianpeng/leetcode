package org.example.array.nsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * https://leetcode.cn/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * 利用哈希表寻找两个数之和为 target 的下标
     * 算法思路：
     * 1. 使用哈希表存储遍历过的数字及其对应的下标。
     * 2. 对于每个数字 num，计算 target - num，检查哈希表中是否已有这个差值。如果有，说明找到了答案。
     * 3. 如果没有，就将当前数字及其下标加入哈希表。
     *
     * @param nums   数组
     * @param target 目标和
     * @return 和为 target 的两个数的下标
     */
    public static int[] twoSum(int[] nums, int target) {
        // 哈希表存储元素及其对应的下标
        Map<Integer, Integer> numsMap = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];// 计算差值
            if (numsMap.get(sub) != null) {
                return new int[]{numsMap.get(sub), i};
            }
            // 如果差值不存在，将当前元素及其下标加入哈希表
            numsMap.put(nums[i], i);
        }

        // 如果没有找到符合条件的答案（题目保证有解）
        return null;
    }


    /**
     * 使用双指针法查找和为目标值的两个数的下标
     * 假设输入数组已经是有序的
     * 算法思路：
     * 1. 使用双指针：一个指针从左端开始，另一个指针从右端开始。
     * 2. 计算两指针所指向的数的和 sum。
     * 3. 如果 sum == target，返回这两个指针所指的下标。
     * 4. 如果 sum < target，移动左指针，增大 sum。
     * 5. 如果 sum > target，移动右指针，减小 sum。
     *
     * @param nums   已排序的整数数组
     * @param target 目标和
     * @return 和为 target 的两个数的下标，若没有则返回 null
     */
    public static int[] twoSum2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 返回找到的下标
                return new int[]{left, right};
            } else if (sum < target) {
                // 如果当前和小于目标，左指针右移
                left++;
            } else {
                // 如果当前和大于目标，右指针左移
                right--;
            }
        }

        // 没有找到符合条件的答案
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));// 输出[0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));// 输出[0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));// 输出[0, 1]
    }
}
