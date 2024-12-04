package org.example.greedy.array;

import java.util.Arrays;

/**
 * 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
 * 并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 示例 1：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 示例 2：
 * 输入：citations = [1,3,1]
 * 输出：1
 * Created on 2024/12/4 15:07
 */
public class HIndex {

    /**
     * 计算研究者的 H 指数。
     * H 指数的定义是：至少有 H 篇论文的引用次数大于等于 H。
     * 算法思路：
     * 1. 将引用次数数组进行升序排序。
     * 2. 从数组的末尾开始遍历，查找最大 H，满足条件：至少有 H 篇论文的引用次数大于等于 H。
     *
     * @param citations 研究者每篇论文的引用次数数组
     * @return 计算得到的 H 指数
     */
    public static int hIndex(int[] citations) {
        System.out.println("Origin:" + Arrays.toString(citations));
        // 对引用次数数组进行升序排序
        Arrays.sort(citations);
        System.out.println("Sorted:" + Arrays.toString(citations));

        // 从数组末尾开始反向遍历
        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            // 如果当前的引用次数大于等于 (n - i)，说明这是一个合法的 h 指数
            if (citations[i] >= hIndex + 1) {
                hIndex++;
            } else {
                // 当前引用次数小于 hIndex + 1，停止查找
                break;
            }
        }

        // 如果没有找到合适的 h 指数，返回 0
        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("H-index: " + hIndex(citations1)); // 输出: 3

        int[] citations2 = {1, 3, 1};
        System.out.println("H-index: " + hIndex(citations2)); // 输出: 1
    }
}
