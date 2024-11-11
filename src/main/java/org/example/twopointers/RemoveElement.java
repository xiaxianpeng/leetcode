package org.example.twopointers;

import org.example.util.ArrayUtil;

/**
 * 移除元素
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * Created on 2024/11/11 18:53
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 慢指针，指向更新后的数组末尾
        int slow = 0;
        // 快指针，遍历原始数组
        int fast = 0;
        // 遍历数组
        while (fast < nums.length) {
            // 如果快指针指向的元素不等于 val
            if (nums[fast] != val) {
                // 将此元素移至数组的慢指针位置
                nums[slow] = nums[fast];
                // 慢指针前进一位
                slow++;
            }
            // 快指针始终前进一位
            fast++;
        }
        // 慢指针的位置即为剩余元素的长度
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        ArrayUtil.print(nums);
        System.out.println(new RemoveElement().removeElement(nums, 3));
        ArrayUtil.print(nums);
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        ArrayUtil.print(nums);
        System.out.println(new RemoveElement().removeElement(nums, 2));
        ArrayUtil.print(nums);
    }
}
