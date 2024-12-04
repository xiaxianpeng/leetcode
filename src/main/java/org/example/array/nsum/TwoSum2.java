package org.example.array.nsum;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 */
public class TwoSum2 {

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
    public static int[] twoSum(int[] nums, int target) {
        int low = 0;
        int height = nums.length - 1;
        while (low < height) {
            int sum = nums[low] + nums[height];
            if (sum == target) {
                // 返回找到的下标
                return new int[]{low, height};
            } else if (sum < target) {
                // 如果当前和小于目标，左指针右移
                low++;
            } else {
                // 如果当前和大于目标，右指针左移
                height--;
            }
        }

        // 没有找到符合条件的答案
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));// 输出[0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));// 输出[0, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));// 输出[0, 1]
    }
}
