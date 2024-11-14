package org.example.array.nsum;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/14 20:02
 */
public class TwoSumFromSortArray {

    /**
     * @param nuns   有序数组
     * @param target 目标值
     * @return 元素下标数组
     * 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。
     * 每次计算两个指针指向的两个元素之和，并和目标值比较。
     * 如果两个元素之和等于目标值，则发现了唯一解。
     * 如果两个元素之和小于目标值，则将左侧指针右移一位。
     * 如果两个元素之和大于目标值，则将右侧指针左移一位。
     * 移动指针之后，重复上述操作，直到找到答案。
     * 链接：https://leetcode-cn.com/problems/kLl5u1/solution/pai-xu-shu-zu-zhong-liang-ge-shu-zi-zhi-8tv13/
     */
    public static int[] twoSumFromSortArray(int[] nuns, int target) {
        // 前一个元素和后一个元素的指针
        int low = 0, high = nuns.length - 1;
        while (low < high) {
            int sum = nuns[low] + nuns[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumFromSortArray(new int[]{2, 7, 11, 15}, 9)));  // 输出示例 1 结果
        System.out.println(Arrays.toString(twoSumFromSortArray(new int[]{2, 3, 4}, 6)));       // 输出示例 2 结果
        System.out.println(Arrays.toString(twoSumFromSortArray(new int[]{-1, 0}, -1)));       // 输出示例 3 结果
    }
}
