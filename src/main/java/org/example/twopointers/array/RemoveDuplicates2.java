package org.example.twopointers.array;


import java.util.Arrays;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 **/
public class RemoveDuplicates2 {

    /**
     * 删除有序数组中的重复元素，使每个元素最多出现两次
     *
     * @param nums 输入的有序数组
     * @return 删除重复项后的新长度
     */
    public static int removeDuplicates(int[] nums) {
        // 如果数组为空，直接返回长度 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 慢指针指向不重复元素的位置，快指针遍历数组
        int slow = 1;
        int fast = 1;

        // 计数器，记录当前数字出现的次数
        int count = 1;

        // 遍历数组，利用快慢指针
        while (fast < nums.length) {
            // 如果当前数字与前一个数字相同
            if (nums[fast] == nums[fast - 1]) {
                count++;// 相同元素出现次数增加
                // 如果当前数字出现的次数不超过2次，放入数组
                if (count <= 2) {
                    nums[slow] = nums[fast];// 将当前数字放入slow指针位置
                    slow++;// 更新slow指针
                }
            } else {
                count = 1;// 如果当前数字与前一个数字不同，重置计数器为1
                nums[slow] = nums[fast];// 将当前数字放入slow指针位置
                slow++;// 更新slow指针
            }
            // 快指针始终向前移动
            fast++;
        }

        // slow的最终值即为去重后的数组长度
        return slow;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(nums1));
        int length1 = removeDuplicates(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println("New Length: " + length1);

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(Arrays.toString(nums2));
        int length2 = removeDuplicates(nums2);
        System.out.println(Arrays.toString(nums2));
        System.out.println("New Length: " + length2);

    }
}
