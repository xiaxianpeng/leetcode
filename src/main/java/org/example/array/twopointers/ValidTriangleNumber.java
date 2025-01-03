package org.example.array.twopointers;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，
 * 返回其中可以组成三角形三条边的三元组个数。
 * 示例 1:
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * Created on 2025/1/3 15:02
 */
public class ValidTriangleNumber {

    /**
     * 有效三角形个个数
     *
     * @param nums 输入的非负整数数组
     * @return 可以组成三角形的三元组个数
     * 算法思路：
     * 首先将数组排序，以便可以有效的使用双指针法
     * 然后固定第三条边(最大的边)，并使用两个指针从数组的开始和固定边的前一个元素向中间移动
     * 判断是否满足三角形不等式 nums[i]+nums[j]>nums[k]
     * 如果满足，则说明nums[j]为边，可以与nums[i]到nums[j-1]之间的所有元素组成三角形
     * 因此将[j-1]加到结果集,并将j左移
     * 如果不满足，则将i右移以尝试更大的nums[i]
     */
    public static int triangleNumber(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        int n = nums.length;
        // 记录三角形的个数
        int count = 0;

        // 从数组的最后一个元素开始，固定第三条边
        for (int k = n - 1; k >= 2; k--) {
            // 初始化左右指针，左指针指向数组的起始，右指针指向固定边的前一个元素
            int i = 0;
            int j = k - 1;

            // 使用双指针查找满足条件的两条边
            while (i < j) {
                // 检查当前两条边，是否满足三角不等式
                if (nums[i] + nums[j] > nums[k]) {
                    // 如果满足，所有从j到j-1的元素与nums[j]都可以组成三角形
                    int validPairs = j - i;
                    count += validPairs;
                    // 右指针左移，尝试更多组合
                    j--;
                } else {
                    // 如果不满足，左指针右移，尝试更大的nums[i]
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(Arrays.toString(nums1));
        System.out.println(triangleNumber(nums1));//3

        int[] nums2 = {4, 2, 3, 4};
        System.out.println(Arrays.toString(nums2));
        System.out.println(triangleNumber(nums2));//4
    }
}
