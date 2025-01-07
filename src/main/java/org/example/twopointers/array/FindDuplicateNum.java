package org.example.twopointers.array;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，
 * 其数字都在 [1, n] 范围内（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3 :
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 * Created on 2025/1/7 15:33
 */
public class FindDuplicateNum {

    /**
     * 使用Floyd（龟兔赛跑）的环检测算法来寻找重复数
     *
     * @param nums 数组
     * @return 重复数
     * 算法思路：
     * 使用快慢指针在环中找到相遇点，再从起点与相遇点同步前进，首次相遇位置即为重复数
     */
    public static int findDuplicate(int[] nums) {
        // 1、定义快慢指针的初始位置
        int slow = nums[0];
        int fast = nums[0];

        // 2、在环上寻找相遇点，快指针移动两步，慢指针移动一步，当两者相遇说明存在环
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 3、将fast重置到起点，与slow同速移动，两次相遇的位置即为重复数
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }
}
