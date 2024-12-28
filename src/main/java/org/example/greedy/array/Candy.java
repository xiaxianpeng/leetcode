package org.example.greedy.array;

import java.util.Arrays;

/**
 * 135. 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * Created on 2024/12/28 22:57
 */
public class Candy {

    /**
     * 给每个孩子分发糖果，最少糖果数目
     *
     * @param ratings 评分
     * @return 最少糖果数目
     * 算法思路:
     * 通过左右两次遍历，确保每个孩子相对于左右邻居的糖果分配符合要求
     * 第一次从左向右遍历，如果当前孩子的评分高于左邻居，则当前糖果数为左邻居+1；
     * 第二次从右向左遍历，如果当前孩子的评分高于右邻居且当前糖果数不大于右邻居，则当前糖果数为右邻居+1；
     * 最后将所有糖果相加得到最小糖果总数
     */
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        // 初始化每个孩子至少有一个糖果
        Arrays.fill(candies, 1);

        // 从左到右遍历，确保右边孩子评分更高时糖果更多
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右到左遍历，确保左边孩子评分更高时糖果更多
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        // 计算总糖果数
        int totalCandy = 0;
        for (int i = 0; i < n; i++) {
            totalCandy += candies[i];
        }
        return totalCandy;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1, 0, 2};
        System.out.println(Arrays.toString(ratings1));
        System.out.println(candy(ratings1));

        int[] ratings2 = {1, 2, 2};
        System.out.println(Arrays.toString(ratings2));
        System.out.println(candy(ratings2));

    }
}
