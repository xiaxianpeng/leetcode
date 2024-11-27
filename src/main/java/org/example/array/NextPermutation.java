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
     * 寻找下一个排列的方法
     * 思路：从后向前找到第一个递减的元素，然后从后找到比它大的元素交换，
     * 最后反转后面的部分。
     *
     * @param nums 输入的整数数组
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 从后向前找到第一个递减的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        System.out.println("Found descending point at index: " + i);


        if (i >= 0) {
            int j = n - 1;
            // 从后向前找到第一个大于nums[i]的元素
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
            System.out.println("Swapped elements at indexes: " + i + " and " + j + " -> " + Arrays.toString(nums));
        }

        // 反转i+1到结尾的元素
        reverse(nums, i + 1);
        System.out.println("Reversed from index " + (i + 1) + " -> " + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Original nums: " + Arrays.toString(nums1));
        nextPermutation(nums1);
        System.out.println("Next permutation for nums1: " + Arrays.toString(nums1)); // 输出 [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        System.out.println("Original nums: " + Arrays.toString(nums2));
        nextPermutation(nums2);
        System.out.println("Next permutation for nums2: " + Arrays.toString(nums2)); // 输出 [1, 2, 3]


        //运行过程说明
        //原始数组：[1, 3, 2, 6, 5, 4]
        //找到第一个递减点：从右向左，2 是最后一个递减点，因为 2 < 6。打印输出 Found descending point at index: 2.
        //寻找大于 2 的数：从右向左找到第一个大于 2 的数是 4。交换 2 和 4。打印输出 Swapped elements at indexes: 2 and 5 -> [1, 3, 4, 6, 5, 2].
        //反转 2 之后的数组：反转位置 3 到末尾的部分 [6, 5, 2]，得到 [2, 5, 6]。打印输出 Reversed from index 3 -> [1, 3, 4, 2, 5, 6].
        int[] nums3 = {1, 3, 2, 6, 5, 4};
        System.out.println("Original nums: " + Arrays.toString(nums3));
        nextPermutation(nums3);
        System.out.println("Next permutation: " + Arrays.toString(nums3)); // 输出 [1, 3, 4, 2, 5, 6]
    }
}
