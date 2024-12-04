package org.example.twopointers.array;

import java.util.Arrays;

import org.example.util.ArrayUtil;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
 * 元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * Created on 2024/11/11 18:53
 */
public class RemoveElement {

    /**
     * 使用双指针法原地移除目标值
     * 核心思路：
     * 1. 使用一个慢指针 `slow` 记录结果数组的位置。
     * 2. 遍历数组，使用快指针 `fast` 检查每个元素。
     * 3. 如果当前元素不等于目标值，则将该元素复制到 `slow` 指针的位置，并移动 `slow`。
     * 4. 最终返回 `slow` 的值，即剩余元素的数量。
     *
     * @param nums 输入数组
     * @param val  需要移除的目标值
     * @return 返回剩余元素的数量
     */
    public static int removeElement(int[] nums, int val) {
        // 慢指针记录修改后的数组位置
        int slow = 0;
        // 快指针，遍历原始数组
        int fast = 0;
        // 遍历数组
        while (fast < nums.length) {
            // 如果当前元素不等于目标值，则保留该元素
            if (nums[fast] != val) {
                nums[slow] = nums[fast];// 将快指针的值赋给慢指针位置
                slow++;// 移动慢指针
            }
            // 快指针始终前进一位
            fast++;
            System.out.println("Step " + fast + ": " + Arrays.toString(nums));
        }
        // 慢指针的位置即为剩余元素的长度
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        ArrayUtil.print(nums);
        System.out.println(removeElement(nums, 3));

        int[] nums2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        ArrayUtil.print(nums2);
        System.out.println(removeElement(nums2, 2));
    }
}
