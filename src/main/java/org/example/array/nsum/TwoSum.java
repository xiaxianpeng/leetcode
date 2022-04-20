package org.example.array.nsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 2020/09/30
 * @time 15:46
 */
public class TwoSum {

    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (numsMap.get(sub) != null) {
                return new int[]{numsMap.get(sub), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }

    /**
     * @param nuns 有序数组
     * @param target 目标值
     * @return 元素下标数组
     *
     * 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
     * 每次计算两个指针指向的两个元素之和，并和目标值比较。
     * 如果两个元素之和等于目标值，则发现了唯一解。
     * 如果两个元素之和小于目标值，则将左侧指针右移一位。
     * 如果两个元素之和大于目标值，则将右侧指针左移一位。
     * 移动指针之后，重复上述操作，直到找到答案。
     * 链接：https://leetcode-cn.com/problems/kLl5u1/solution/pai-xu-shu-zu-zhong-liang-ge-shu-zi-zhi-8tv13/
     */
    public static int[] twoSumFromSortArray(int[] nuns, int target) {
        // 前一个元素和后一个元素的指针
        int low = 0, high = nuns.length - 1;
        while (low < high) {
            int sum = nuns[low] + nuns[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] indexes = twoSumFromSortArray(nums, target);
        System.out.println(Arrays.toString(indexes));
    }
}
