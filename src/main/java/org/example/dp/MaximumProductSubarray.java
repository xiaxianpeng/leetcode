package org.example.dp;

/**
 * @author xianpeng.xia
 * on 2022/4/6 6:53 PM
 * ### 乘积最大非空连续子数组
 *
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 给你一个整数数组 nums，
 * 请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * 测试用例的答案是一个32-位 整数。
 *
 * 子数组 是数组的连续子序列。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumProductSubarray {

    /**
     * 标签：动态规划
     * 遍历数组时计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)O(n)
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            // 如果 nums[i] < 0，最大的与最小值将互换
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        int maxProduct = maxProduct(nums);
        System.out.println(maxProduct);
    }
}
