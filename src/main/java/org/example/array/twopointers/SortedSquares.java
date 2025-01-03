package org.example.array.twopointers;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，
 * 要求也按 非递减顺序 排序。
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 */
public class SortedSquares {

    /**
     * 使用双指针法计算有序数组的平方并排序
     *
     * @param nums 已排序的整数数组
     * @return 排序后的平方
     * 算法思想：
     * 因为原数组已有序，负数的平方可能较大
     * 使用两个指针从数组两端向中间遍历
     * 比较两端的平方值，将较大的值放入结果数组的末尾
     * 最终得到一个递增排序的平方数组
     */
    public int[] sortedSquares(int[] nums) {
        // 初始化双指针
        int left = 0;
        int right = nums.length - 1;
        // 结果数组填充位置
        int index = nums.length - 1;
        int[] result = new int[nums.length];

        // 遍历数组，直到左右指针交错
        while (left <= right) {
            // 计算左右指针元素的平方
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            // 比较左右平方值，将较大者放入结果数组
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }

        // 返回排序后的平方数组
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] squares = new SortedSquares().sortedSquares(nums);
        System.out.println(Arrays.toString(squares));
    }
}
