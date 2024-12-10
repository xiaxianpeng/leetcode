package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers {

    /**
     * 遍历 nums，每遇到一个数 x，就让 nums[x−1] 增加 n。
     * 由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n。
     * 最后我们遍历 nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        // 1，通过遍历，将出现过的数字对应位置上的元素进行累加n的操作
        for (int num : nums) {
            // 利用 (num-1)%n 找到数字num对应的索引位置
            int index = (num - 1) % n;
            // 对应位置加n，表示出现过该数字
            nums[index] = nums[index] + n;
        }
        System.out.println("标记完成，开始寻找缺失数字：" + Arrays.toString(nums));
        List<Integer> missNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                int missNum = i + 1;
                missNums.add(missNum);
            }
        }

        System.out.println("缺失的数字列表：" + missNums);
        return missNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
