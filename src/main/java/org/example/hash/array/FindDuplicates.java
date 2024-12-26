package org.example.hash.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给你一个长度为 n 的整数数组 nums ，
 * 其中 nums 的所有整数都在范围 [1, n] 内，
 * 且每个整数出现 最多两次 。
 * 请你找出所有出现 两次 的整数，并以数组形式返回。
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间（不包括存储输出所需的空间）的算法解决此问题。
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[]
 * Created on 2024/12/26 11:49
 */
public class FindDuplicates {

    /**
     * 数组中重复的数据
     *
     * @param nums 数组
     * @return 重复元素集合
     * 算法思路：
     * 遍历数组，将每个数对应的索引位置的元素取负数
     * 如果某个位置已经是负数，说明该数已经出现过一次，是重复的
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素的索引位置
            int index = Math.abs(nums[i]) - 1;

            // 检查索引位置是否是负数
            if (nums[index] < 0) {
                // 如果是负数，说明出现过一次，是重复的
                duplicates.add(Math.abs(nums[i]));
            } else {
                // 如果是正数，取负数标记为已访问
                nums[index] = -nums[index];
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDuplicates(new int[]{1, 1, 2}));
        System.out.println(findDuplicates(new int[]{1}));
    }
}
