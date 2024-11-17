package org.example.greedy;

import java.util.Arrays;

/**
 * 1. 分糖果
 * 我们有 m 个糖果和 n 个孩子。我们现在要把糖果分给这些孩子吃，但是糖果少，孩子多（m<n），所以糖果只能分配给一部分孩子。
 * 每个糖果的大小不等，这 m 个糖果的大小分别是 s1，s2，s3，……，sm。除此之外，每个孩子对糖果大小的需求也是不一样的，只有糖果的大小大于等于孩子的对糖果大小的需求的时候，孩子才得到满足。假设这 n 个孩子对糖果大小的需求分别是 g1，g2，g3，……，gn。
 * 我的问题是，如何分配糖果，能尽可能满足最多数量的孩子？
 * 我们可以把这个问题抽象成，从 n 个孩子中，抽取一部分孩子分配糖果，让满足的孩子的个数（期望值）是最大的。这个问题的限制值就是糖果个数 m。
 * 我们现在来看看如何用贪心算法来解决。对于一个孩子来说，如果小的糖果可以满足，我们就没必要用更大的糖果，这样更大的就可以留给其他对糖果大小需求更大的孩子。另一方面，对糖果大小需求小的孩子更容易被满足，所以，我们可以从需求小的孩子开始分配糖果。因为满足一个需求大的孩子跟满足一个需求小的孩子，对我们期望值的贡献是一样的。
 * 我们每次从剩下的孩子中，找出对糖果大小需求最小的，然后发给他剩下的糖果中能满足他的最小的糖果，这样得到的分配方案，也就是满足的孩子个数最多的方案。
 */
public class CandyDistribution {

    public static int distributeCandies(int[] candies, int[] children) {
        // 排序
        Arrays.sort(candies);
        Arrays.sort(children);
        // 当前考虑的糖果索引
        int candyIndex = 0;
        // 当前考虑的孩子索引
        int childIndex = 0;
        while (candyIndex < candies.length && childIndex < children.length) {
            if (candies[candyIndex] >= children[childIndex]) {
                // 满足孩子需求，移动到下一个孩子
                childIndex++;
            }
            // 不管是否满足孩子，都移动到下一个糖果，因为当前糖果已经分配（或尝试分配）过了
            candyIndex++;
        }
        // 最终满足的孩子数量就是成功分配的孩子数
        return childIndex;
    }

    public static void main(String[] args) {
        int[] candies = {1, 1}; // 糖果的大小
        int[] children = {1, 2, 3}; // 孩子的需求

        int result = distributeCandies(candies, children);
        System.out.println("最多可以满足的孩子数量是：" + result);
    }

}
