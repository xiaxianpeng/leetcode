package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/5 11:29 AM
 * 移动某个元素
 * 给定⼀个数组 nums，编写⼀个函数将所有 0 移动到数组的末尾，
 * 必须在原数组上操作，同时保持⾮零元素 的相对顺序。
 * 示例：输⼊：[0,1,0,3,12]
 * 输出：[1,3,12,0,0]
 */
public class RemoveElement {

    public static void moveZeroes(int[] nums) {
        int p = removeElement(nums, 0);

        // 将p之后的元素赋值为0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
