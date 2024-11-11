package org.example.twopointers;


import org.example.util.ArrayUtil;

/**
 * .
 * 26. 删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，
 * 使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * <p>
 * Created on 2024/11/11 18:32
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        // 如果数组为空，直接返回长度 0
        if (nums.length == 0) {
            return 0;
        }
        // 慢指针，用于记录新数组的最后一个元素的索引
        int slow = 0;
        // 快指针，用于遍历数组中的元素
        int fast = 0;
        // 遍历整个数组
        while (fast < nums.length) {
            // 当快慢指针指向的元素不相同时，表示发现了新的非重复元素
            if (nums[fast] != nums[slow]) {
                // 移动慢指针，并将新的非重复元素赋值给慢指针所在位置
                slow++;
                nums[slow] = nums[fast];
            }
            // 快指针始终向前移动
            fast++;
        }
        // 返回新的数组长度（慢指针索引 + 1）
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3};
        ArrayUtil.print(nums);
        System.out.println(removeDuplicates(nums));
        ArrayUtil.print(nums);
        System.out.println("~~~~~~~~~~~~~~");
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        ArrayUtil.print(nums);
        System.out.println(removeDuplicates(nums));
        ArrayUtil.print(nums);

    }
}
