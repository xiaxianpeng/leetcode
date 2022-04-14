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
    private int[] preSum;

    /**
     * /* 输入一个数组，构造前缀和
     */
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        // preSum[0] = 0，便于计算累加和
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    /**
     * 查询闭区间 [left, right] 的累加和
     */
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
