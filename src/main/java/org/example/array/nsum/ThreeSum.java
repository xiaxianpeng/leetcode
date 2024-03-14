package org.example.array.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xiapeng
 * @Date: 2022/03/29/2:29 下午
 * <p>
 * 三数之和等于0
 * <p>
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
        List<List<Integer>> lists = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 双指针
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 因为已经排序好，所以后面不可能有三个数加和等于0
            if (nums[i] > 0) {
                return lists;
            }
            // 避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int temp = curr + nums[L] + nums[R];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 相同数过滤
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                    // temp<0，说明nums[L]过小
                } else if (temp < 0) {
                    L++;
                    // temp>0，说明nums[R]过大
                } else {
                    R--;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
