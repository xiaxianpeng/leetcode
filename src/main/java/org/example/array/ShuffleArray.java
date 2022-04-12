package org.example.array;

import java.util.Arrays;
import java.util.Random;

/**
 * @author xianpeng.xia
 * on 2022/4/12 8:38 AM
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例 1：
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 */
public class ShuffleArray {

    /**
     * 原始数据
     */
    int[] nums;
    int n;
    Random random = new Random();

    /**
     * @param nums nums
     * 使用整数数组 nums 初始化对象
     */
    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }

    /**
     * 重设数组到它的初始状态
     */
    public int[] reset() {
        return nums;
    }

    /**
     * 随机返回数组,打乱后的结果
     * Knuth洗牌算法
     * 从前往后尝试填充[0,n−1] 该填入什么数时，通过随机当前下标与（剩余的）哪个下标进行值交换来实现。
     */
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(nums));
        ShuffleArray shuffleArray = new ShuffleArray(nums);
        int[] shuffle = shuffleArray.shuffle();
        System.out.println(Arrays.toString(shuffle));
        int[] reset = shuffleArray.reset();
        System.out.println(Arrays.toString(reset));
    }
}
