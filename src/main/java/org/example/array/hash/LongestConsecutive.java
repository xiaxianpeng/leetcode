package org.example.array.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive {

    /**
     * 算法思路：
     * 1. 使用 HashSet 存储数组中的元素，以便 O(1) 时间复杂度进行查找。
     * 2. 遍历数组中的每个元素，判断该元素是否是某个连续序列的起点（即 num-1 不在集合中）。
     * 3. 对于每个起点，向后查找连续的数字，更新最大长度。
     * 4. 最终返回最长连续序列的长度。
     *
     * @param nums 输入的整数数组
     * @return 最长连续序列的长度
     */
    public static int longestConsecutive(int[] nums) {
        // 使用 HashSet 存储数组中的所有数字
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // 遍历集合中的每个数字
        for (Integer num : numSet) {

            // 只从序列的起点开始查找
            if (!numSet.contains(num - 1)) {
                int curNum = num; // 当前数字
                int curLength = 1;// 当前序列长度

                // 查找连续的数字
                while (numSet.contains(curNum + 1)) {
                    curNum++;
                    curLength++;
                }

                // 更新最大长度
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Length: " + longestConsecutive(nums1));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Length: " + longestConsecutive(nums2));
    }
}
