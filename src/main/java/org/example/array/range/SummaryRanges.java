package org.example.array.range;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * Created on 2024/12/6 10:20
 */
public class SummaryRanges {

    /**
     * 汇总区间
     * 核心思路：
     * 1. 遍历数组，找出连续的区间。
     * 2. 如果当前数字与前一个数字连续，则继续，否则记录并开始新的区间。
     * 3. 对于每个区间，输出合适的格式："a->b" 或者 "a"。
     *
     * @param nums 输入的整数数组，数组是有序的
     * @return 区间范围列表
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }

        int start = 0; // 记录每个区间的开始位置

        // 遍历数组
        for (int i = 1; i <= nums.length; i++) {
            // 如果当前元素与前一个元素不连续，或者当 i 达到数组末尾
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (i - start == 1) {
                    // 如果区间内只有一个数字，则直接添加该数字
                    ranges.add("" + nums[i - 1]);
                } else {
                    // 否则添加区间 "a->b"
                    ranges.add(nums[start] + "->" + nums[i - 1]);
                }
                // 更新区间起点
                start = i;
            }
        }

        return ranges;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums1)); // 输出: ["0->2", "4->5", "7"]

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums2)); // 输出: ["0", "2->4", "6", "8->9"]
    }
}
