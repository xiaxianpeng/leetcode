package org.example.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * https://leetcode.cn/problems/4sum/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/13 20:37
 */
public class FourSum {

    /**
     * 为了解决这个问题，我们可以使用类似于三数之和问题的方法。
     * 我们先对数组进行排序，然后使用双指针法。
     * 不同之处在于，我们需要在外层再加两重循环来遍历所有可能的四元组。
     * 以下是详细步骤：
     * 1、对数组 nums 进行排序。
     * 2、遍历排序后的数组，对于索引 i（第一个数字）和 j（第二个数字），
     * 使用两个指针 left（第三个数字）和 right（第四个数字）在 j 后面的范围内移动。
     * 3、如果找到 nums[i] + nums[j] + nums[left] + nums[right] == target，
     * 则将这四个数字加入到结果列表中。同时移动指针，跳过相同的数字以避免重复的四元组。
     * 4、如果和小于目标值，则移动 left 指针；如果和大于目标值，则移动 right 指针。
     * 5、对于每一重循环，注意跳过相同的数字以避免重复的四元组。
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序数组
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 遍历数组，注意要留出位置给 j, left 和 right
        for (int i = 0; i < nums.length - 3; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 定义双指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // 找到满足条件的四元组，加入结果集
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 跳过重复元素
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        // 和小于目标值，左指针右移
                        left++;
                    } else {
                        // 和大于目标值，右指针左移
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println(ans);
    }
}
