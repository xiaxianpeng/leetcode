package org.example.twopointers.array;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * 示例 1：
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 示例 2：
 * 输入：nums = [2,3]
 * 输出：[2,3]
 * Created on 2024/12/6 09:22
 */
public class SortArrayByParity2 {

    /**
     * 按奇偶排序数组 II
     * 核心思路：
     * 使用双指针方法，分别处理奇数和偶数的插入位置。
     * 通过两个指针，分别处理数组中奇数和偶数元素的位置。
     * 偶数元素放置在偶数下标，奇数元素放置在奇数下标。
     *
     * @param nums 输入的整数数组，包含相同数量的奇数和偶数
     * @return 排序后的数组，满足奇数位上是奇数，偶数位上是偶数
     */
    public static int[] sortArrayByParityII(int[] nums) {
        // 初始化两个指针
        // 奇数的指针，指向数组的奇数下标
        int oddIndex = 1;
        // 偶数的指针，指向数组的偶数下标
        int evenIndex = 0;
        while (oddIndex < nums.length && evenIndex < nums.length) {
            // 偶数位置上是奇数，交换偶数位置的元素
            if (nums[evenIndex] % 2 == 1) {
                // 交换 nums[evenIndex] 和 nums[oddIndex]
                swap(nums, oddIndex, evenIndex);
                // 更新奇数指针，移动到下一个奇数位置
                oddIndex += 2;
            }
            // 如果奇数位置是偶数，交换奇数位置的元素
            else if (nums[oddIndex] % 2 == 0) {
                // 交换 nums[oddIndex] 和 nums[evenIndex]
                swap(nums, oddIndex, evenIndex);
                // 更新偶数指针，移动到下一个偶数位置
                evenIndex += 2;
            } else {
                // 否则直接移动两个指针
                oddIndex += 2;
                evenIndex += 2;
            }
        }
        return nums;
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums 数组
     * @param i    索引 i
     * @param j    索引 j
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));

        int[] nums1 = {2, 3};
        System.out.println(Arrays.toString(sortArrayByParityII(nums1)));
    }
}
