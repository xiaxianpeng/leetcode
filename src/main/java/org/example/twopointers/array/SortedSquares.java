package org.example.twopointers.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/5/6 01:09
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 */
public class SortedSquares {

    /**
     * @param nums nums
     * @return nums平方排序
     * 双指针
     *
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/acm-xuan-shou-tu-jie-leetcode-you-xu-shu-h8le/
     */
    public int[] sortedSquares(int[] nums) {
        // 右指针
        int right = nums.length - 1;
        // 左指针
        int left = 0;
        int[] ans = new int[nums.length];
        // index
        int index = ans.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[index] = nums[left] * nums[left];
                left++;
            } else {
                ans[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] squares = new SortedSquares().sortedSquares(nums);
        System.out.println(Arrays.toString(squares));
    }
}
