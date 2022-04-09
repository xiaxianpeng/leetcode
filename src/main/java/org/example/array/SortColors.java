package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/9 7:31 PM
 *
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class SortColors {

    /**
     * 双指针
     */
    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // all in [0,zero) = 0
        // all in [zero,i) = 1
        // all in [i,len-1] = 2

        // 为0的右边界
        int zero = 0;
        // 为2的左边界
        int two = len;
        // 指针
        int p = 0;
        while (p < two) {
            if (nums[p] == 0) {
                swap(nums, p, zero);
                zero++;
                p++;
            } else if (nums[p] == 1) {
                p++;
            } else {
                two--;
                swap(nums, p, two);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
