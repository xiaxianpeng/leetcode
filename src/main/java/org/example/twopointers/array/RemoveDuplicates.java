package org.example.twopointers.array;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
 * nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {

    /**
     * 通过双指针法删除排序数组中的重复元素。
     * 核心策略：使用指针遍历数组，发现新的不重复元素时，
     * 将其放置在数组前部并更新新数组的长度。
     *
     * @param nums 输入的排序数组
     * @return 新数组的长度（即去重后的数组长度）
     */
    public static int removeDuplicates(int[] nums) {
        // 特殊情况：如果数组为空，直接返回0
        if (nums.length == 0) {
            return 0;
        }
        // slow 指针，记录去重后数组的末尾
        int slow = 0;
        // fast 指针，用于遍历整个数组
        int fast = 0;

        // 遍历整个数组
        while (fast < nums.length) {
            // 如果 fast 和 slow 指向的元素不相等，说明遇到一个新元素
            if (nums[fast] != nums[slow]) {
                slow++;// 增加 slow，表示去重后的数组长度
                //维护nums[0,slow]无重复
                nums[slow] = nums[fast]; // 更新 slow 后的位置
            }
            fast++;// 移动 fast 指针，继续遍历下一个元素
        }

        // 返回去重后的数组长度
        return slow + 1;// slow 是最后一个不重复元素的索引，长度是索引 + 1
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums2));

    }
}
