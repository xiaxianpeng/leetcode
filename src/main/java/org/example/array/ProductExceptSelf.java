package org.example.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，
 * 其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * Created on 2024/11/27 16:46
 */
public class ProductExceptSelf {

    /**
     * 计算除自身以外数组的乘积
     * 思路：使用左右两遍遍历的方式，先计算每个元素左侧乘积，再计算右侧乘积并直接更新结果。
     *
     * @param nums 输入的整数数组
     * @return 返回除自身以外的乘积数组
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 初始化结果数组为1，因为乘积的单位元是1
        Arrays.fill(result, 1);
        System.out.println("Initial result: " + Arrays.toString(result));

        // 第一次遍历：计算左侧乘积
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] *= leftProduct;
            leftProduct *= nums[i];
            System.out.println("After processing left index " + i + ": " + Arrays.toString(result));
        }

        // 第二次遍历：计算右侧乘积并更新结果
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
            System.out.println("After processing right index " + i + ": " + Arrays.toString(result));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Product except self for nums1: " + Arrays.toString(result1)); // 输出 [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("Product except self for nums2: " + Arrays.toString(result2)); // 输出 [0, 0, 9, 0, 0]
    }
}
