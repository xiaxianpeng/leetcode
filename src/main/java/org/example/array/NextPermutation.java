package org.example.array;


import java.util.Arrays;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，
 * 那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，
 * 因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * Created on 2024/11/27 13:33
 */
public class NextPermutation {

    /**
     * 生成给定数组的下一个排列
     * 算法思路：
     * 1、从后向前找到第一个递增的位置i，使得nums[i]<nums[i+1]，
     * 2、如果找到，找到数组末端向前的第一个元素j，并于nums[i]交换
     * 3、反转从i+1到数组末尾的所有元素，以获得下一个字典序更大的排列
     *
     * @param nums 输入的整数数组
     */
    public static void nextPermutation(int[] nums) {
        System.out.println("原始数组: " + Arrays.toString(nums));
        int n = nums.length;
        int i = n - 2;

        // 从后向前找到，第一个位置递增位置i，使得nums[i]<nums[i+1]，即第一个正序对
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        System.out.println("找到第一个递增位置 i: " + i);

        if (i >= 0) {
            int j = n - 1;
            // 从数组末尾开始查找，第一个大于nums[i]的元素
            while (nums[j] <= nums[i]) {
                j--;
            }
            System.out.println("将要与 nums[i] 交换的元素的位置 j: " + j);
            // 交换这两个元素
            swap(nums, i, j);
            System.out.println("交换后的数组: " + Arrays.toString(nums));
        }

        // 反转从i+1到数组末尾的元素
        reverse(nums, i + 1);
        System.out.println("反转" + i + "+1到结尾后的数组: " + Arrays.toString(nums));
    }

    /**
     * 反转数组中从开始索引到末尾的所有元素
     *
     * @param nums  数组
     * @param start 开始索引
     */
    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    /**
     * 交换数组中的两个元素
     *
     * @param nums 数组
     * @param i    第一个元素的索引
     * @param j    第二个元素的索引
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);

        int[] nums3 = {1, 3, 5, 4, 2};
        nextPermutation(nums3);
    }
}
