package org.example.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。
 * 这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。
 * 采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * 示例 2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * 示例 4：
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * Created on 2024/12/23 14:19
 */
public class FruitIntoBaskets {

    /**
     * 通过维护一个滑动窗口，在窗口内同时只保留两种类型的水果
     * 使用HashMap记录每种水果的出现次数
     * 当发现超过两种水果时，不断缩小窗口直至回到只保留两种水果为止
     * 最后在遍历过程中动态维护窗口最大值，得到能收集的水果数
     *
     * @param fruits 水果种类数组
     * @return 可以收集到的最大水果数量
     */
    public static int totalFruit(int[] fruits) {
        // 如果数组为空或长度为0，直接返回0
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        // 用来维护窗口内(水果类型->出现次数)的映射
        Map<Integer, Integer> countMap = new HashMap<>();

        // 滑动窗口的左指针
        int left = 0;
        // 记录最大窗口大小(可收集的水果数量)
        int maxFruits = 0;

        // 遍历数组，右指针从0开始移动
        for (int right = 0; right < fruits.length; right++) {
            // 将当前水果计数
            int currentFruit = fruits[right];
            countMap.put(currentFruit, countMap.getOrDefault(currentFruit, 0) + 1);

            // 如果窗口内水果种类超过2，开始收缩左边界
            while (countMap.size() > 2) {
                Integer leftFruit = fruits[left];
                // 左指针指向的水果计数减一
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                // 如果左指针指向的水果类型计数减到0，移除该水果类型
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }
                // 移动左指针
                left++;
            }
            // 更新最大水果数量
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        // 返回最终的最大水果数量
        return maxFruits;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));//3
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));//3
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));//4
        System.out.println(totalFruit(null));//0
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));//5
        System.out.println(totalFruit(new int[]{1, 1, 1, 1}));//4
    }
}
