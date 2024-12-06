package org.example.twopointers.array;

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * 返回满足此条件的 任一数组 作为答案。
 * 示例 1：
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[0]
 * Created on 2024/12/6 08:49
 */
public class SortArrayByParity {

    /**
     * 按奇偶排序数组
     * 核心思路：
     * 使用双指针方法，左指针从头开始寻找奇数，右指针从头开始寻找偶数。
     * 如果左指针指向的是奇数，右指针指向的是偶数，则交换它们的位置。
     *
     * @param nums 输入的整数数组
     * @return 排序后的数组，偶数在前，奇数在后
     */
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;// 左指针，初始指向数组开头
        int right = nums.length - 1; // 右指针，初始指向数组结尾

        while (left < right) {

            // 左指针指向偶数，右移
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            // 右指针指向奇数，左移
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }

            // 左指针指向奇数，右指针指向偶数，交换它们
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                // 交换完成后移动指针
                left++;
                right--;
            }
        }
        return nums;
    }

    /**
     * 按奇偶排序数组（使用新数组）
     * 核心思路：
     * 该方法创建一个新的数组 `result`，将所有偶数元素放到数组的左侧，奇数元素放到数组的右侧。
     * 使用两个指针，一个 `left` 用于指向结果数组中偶数的位置，另一个 `right` 用于指向奇数的位置。
     * 遍历输入数组 `nums`，遇到偶数则将其放到 `left` 指针的位置，遇到奇数则将其放到 `right` 指针的位置。
     *
     * @param nums 输入的整数数组
     * @return 返回按奇偶排序的数组，偶数在前，奇数在后
     */
    public static int[] sortArrayByParity2(int[] nums) {
        int[] result = new int[nums.length];// 创建一个新的数组来存储结果
        int left = 0;// 左指针，指向偶数的插入位置
        int right = nums.length - 1; // 右指针，指向奇数的插入位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[left] = nums[i];// 偶数放在左侧
                left++;
            } else {
                result[right] = nums[i]; // 奇数放在右侧
                right--;
            }
        }
        // 返回新创建的数组
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums1)));
    }
}
