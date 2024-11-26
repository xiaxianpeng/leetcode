package org.example.array.greedy;

import java.util.ArrayList;
import java.util.List;

/**
     * 1431. 拥有最多糖果的孩子
 * 提示
 * 有 n 个有糖果的孩子。给你一个数组 candies，
 * 其中 candies[i] 代表第 i 个孩子拥有的糖果数目，
 * 和一个整数 extraCandies 表示你所有的额外糖果的数量。
 * 返回一个长度为 n 的布尔数组 result，如果把所有的 extraCandies 给第 i 个孩子之后，
 * 他会拥有所有孩子中 最多 的糖果，那么 result[i] 为 true，否则为 false。
 * 注意，允许有多个孩子同时拥有 最多 的糖果数目。
 * 示例 1：
 * 输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
 * 解释：如果你把额外的糖果全部给：
 * 孩子 1，将有 2 + 3 = 5 个糖果，是孩子中最多的。
 * 孩子 2，将有 3 + 3 = 6 个糖果，是孩子中最多的。
 * 孩子 3，将有 5 + 3 = 8 个糖果，是孩子中最多的。
 * 孩子 4，将有 1 + 3 = 4 个糖果，不是孩子中最多的。
 * 孩子 5，将有 3 + 3 = 6 个糖果，是孩子中最多的。
 * 示例 2：
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 * 示例 3：
 * 输入：candies = [12,1,12], extraCandies = 10
 * 输出：[true,false,true]
 * Created on 2024/11/17 23:34
 */
public class KidsWithCandies {

    /**
     * 解题思路：
     * 1. 首先，我们需要计算出当前所有孩子拥有的最多糖果数 maxCandies。
     * 2. 然后，我们遍历每个孩子，检查如果给该孩子额外糖果后，他是否能拥有最多糖果。
     * 如果能，那么该孩子会拥有最多糖果，将对应位置结果设为 true；否则设为 false。
     * 3. 最终返回布尔数组 result，其中每个元素表示该孩子是否能成为拥有最多糖果的孩子。
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 找到当前糖果的最大值
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        // 逐个计算每个孩子在加上额外糖果后的状态
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3)); // 输出：[true, true, true, false, true]
        System.out.println(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1)); // 输出：[true, false, false, false, false]
        System.out.println(kidsWithCandies(new int[]{12, 1, 12}, 10));    // 输出：[true, false, true]
    }
}
