package org.example.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和等于0
 * 特判，对于数组长度 n，如果数组为 null或者数组长度小于 3，返回 []。
 * 对数组进行排序。
 * 遍历排序后数组：
 * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
 * 对于重复元素：跳过，避免出现重复解
 * 令左指针 L=i+1，右指针 R=n−1，当 L<R 时，执行循环：
 * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
 * 若和大于 0，说明 nums[R] 太大，R左移
 * 若和小于 0，说明 nums[L] 太小，L右移
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // 1、先将 nums 排序，时间复杂度为 O(NlogN)。
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 双指针
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;// 因为后面的数都大于零，不可能和为零
            }
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;// 跳过重复元素
            }
            // L，R 分设在数组索引 (i,len(nums)) 两端，当L < R时循环计算sum = nums[i] + nums[L] + nums[R]，
            // 并按照以下规则执行双指针移动：
            //  当sum < 0时，L += 1并跳过所有重复的nums[L]；
            //  当sum > 0时，R -= 1并跳过所有重复的nums[R]；
            //  当sum == 0时，记录组合[k, L, R]至res，执行L += 1和R -= 1并跳过所有重复的nums[L]和nums[R]，防止记录到重复组合。
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    ans.add(list);
                    // 相同数过滤
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    // 和小于零，左指针右移
                    L++;
                } else {
                    // 和大于零，右指针左移
                    R--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
