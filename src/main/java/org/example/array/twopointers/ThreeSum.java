package org.example.array.twopointers;

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

    /**
     * 找到所有不重复的三元组，使得每个三元组的和为0。
     *
     * @param nums 输入的整数数组
     * @return 所有不重复的三元组列表
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 先将 nums 排序，时间复杂度为 O(NlogN)。
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        // 遍历排序后的数组
        for (int i = 0; i < len; i++) {
            // 特殊情况：如果当前数大于0，后续不可能再找到和为0的组合
            // 当 nums[i] > 0 时直接break跳出：因为 nums[R] >= nums[L] >= nums[i] > 0，
            // 即 3 个元素都大于 0 ，在此固定指针 i 之后不可能再找到结果了。
            if (nums[i] > 0) {
                break;
            }

            // 跳过重复的元素
            // 当 i > 0且nums[i] == nums[i - 1]时即跳过此元素nums[i]：
            // 因为已经将 nums[i - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 定义双指针
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
                    // 跳过重复的左指针元素
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    // 跳过重复的右指针元素
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    // 移动指针
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;// 如果 sum < 0，说明左指针所指元素过小
                } else {
                    R--;// 如果 sum > 0，说明右指针所指元素过大
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
