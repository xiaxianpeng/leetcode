package org.example.array.twopointers;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。
 * Created on 2024/12/30 23:55
 */
public class ThreeSumClosest {

    /**
     * 使用排序和双指针的方法找到与目标值最接近的三个数之和
     *
     * @param nums   输入的整数数组
     * @param target 目标值
     * @return 与目标值最接近的三个数之和
     * 算法思路:
     * 1、将数组排序
     * 2、遍历数组，对于每个元素，使用两个指针从剩余部分寻找最接近的两数之和
     * 3、更新最接近的结果
     */
    public static int threeSumClosest(int[] nums, int target) {
        // 对数组排序
        Arrays.sort(nums);
        // 初始化最接近的和为前三个数的和
        int closestSum = nums[0] + nums[1] + nums[2];

        // 遍历数组，每次固定一个数，然后使用双指针寻找另外两个数
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // 计算三个数的和
                int currentSum = nums[i] + nums[left] + nums[right];

                // 如果当前和更接近目标值，更新closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // 根据当前和与目标的比较，移动指针
                if (currentSum > target) {
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    return currentSum;
                }
            }
        }

        // 返回最接近的和
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("输入: " + Arrays.toString(nums1) + ", 目标值: " + target1);
        int result1 = threeSumClosest(nums1, target1);
        System.out.println("输出: " + result1 + "\n");

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("输入: " + Arrays.toString(nums2) + ", 目标值: " + target2);
        int result2 = threeSumClosest(nums2, target2);
        System.out.println("输出: " + result2);
    }
}
