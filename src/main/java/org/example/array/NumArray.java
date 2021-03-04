package org.example.array;

/**
 * @date 2021/03/04
 * @time 15:15
 * <p>
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * <p>
 * 区域和检索 - 数组不可变
 */
public class NumArray {

    /**
     * sum[i]存储前i个元素和,sun[i]存储nums[0,...i-1]的和,sum[0] = 0,
     */
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];

        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
