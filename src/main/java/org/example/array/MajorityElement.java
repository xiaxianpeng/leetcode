package org.example.array;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement {

    /**
     * 使用Boyer-Moore 投票算法找到多数元素
     * 思路：多数元素出现的次数大于其他元素总和，因此可以通过投票
     * 算法来确定。每次从数组中取出一个候选，抵消一个非候选，最后
     * 剩下的就是多数元素。
     *
     * @param nums 输入数组
     * @return 数组中的多数元素
     */
    public static int majorityElement(int[] nums) {
        // 初始化候选元素和计数器
        int candidate = nums[0];
        int count = 0;

        // 遍历数组
        for (int num : nums) {
            // 如果计数器为0，选择新的候选元素
            if (count == 0) {
                candidate = num;
                // 如果当前元素等于候选元素，增加计数器，否则减少
                count += (num == candidate) ? 1 : -1;
                System.out.println("Current number: " + num + ", Candidate: " + candidate + ", Count: " + count);
            }
        }
        //  返回多数元素
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("Result for nums1: " + majorityElement(nums1)); // 输出3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Result for nums2: " + majorityElement(nums2)); // 输出2
    }
}
