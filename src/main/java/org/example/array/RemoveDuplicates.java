package org.example.array;

/**
 * @Author xiapeng
 * @Date: 2022/03/28/4:22 下午
 * @Description: 删除有序数组的重复元素
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                //维护nums[0,slow]无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3};
        int i = removeDuplicates(nums);
        System.out.println();
    }
}
