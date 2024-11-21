package org.example.array.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1679. K 和数对的最大数目
 * 给定一个整数数组 nums 和一个整数 k。
 * 每一步操作中，从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回可以对数组执行的最大操作数。
 * 示例 1：
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 示例 2：
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * Created on 2024/11/18 09:38
 */
public class MaxNumberOfKSumPairs {
    /**
     * 使用哈希表记录数字出现的次数，匹配和为 k 的数对。
     * <p>
     * 核心思路：
     * 1. 遍历数组，记录每个数字的出现次数。
     * 2. 如果当前数字 num 的 diff（k - num）已在哈希表中，则配对并减少次数。
     * 3. 否则，将 num 加入哈希表记录其出现次数。
     * <p>
     * 时间复杂度：O(n)，其中 n 是数组的长度。
     * 空间复杂度：O(n)，需要哈希表存储元素频次。
     */
    public static int maxOperations(int[] nums, int k) {
        int operations = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            // 如果 diff 存在并且数量大于 0，可以配对
            int diff = k - num;
            if (countMap.getOrDefault(diff, 0) > 0) {
                // 增加配对数
                operations++;
                // 减少 diff 的数量
                countMap.put(diff, countMap.getOrDefault(diff, 0) - 1);
            } else {
                // 否则将 num 加入哈希表
                countMap.put(num, countMap.getOrDefault(diff, 0) + 1);
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5)); // 输出：2
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // 输出：1
    }

}
