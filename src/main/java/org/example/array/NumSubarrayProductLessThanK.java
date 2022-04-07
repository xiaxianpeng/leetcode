package org.example.array;

/**
 * @author xianpeng.xia
 * on 2022/4/7 11:34 PM
 * 给定一个正整数数组 nums和整数 k ，
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 提示:
 *
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 * 示例
 *
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8 个乘积小于 100 的子数组分别为: [10], [5],
 * [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * 示例 2:
 * 输入: nums = [1,2,3], k = 0
 * 输出: 0
 *
 * 作者：qingfengpython
 * 链接：https://leetcode-cn.com/problems/ZVAVXX/solution/jian-zhi-offerii009cheng-ji-xiao-yu-kde-q158e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumSubarrayProductLessThanK {

    /**
     * @param nums 数组
     * @param k 和
     * @return 数组内乘积小于K的连续子数组个数
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 数组内乘积小于K的连续子数组个数
        int ans = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;
        // 乘积
        int product = 1;
        while (right < nums.length) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            //此时保证了product是小于k的，相当于求右边界左边界为l，右边界为r的连续子数组的个数，
            //右边界是不断递增的，又因为是连续，所以满足条件的每种长度的子数组只会有一个
            //且右边界一直在变也就是不会重复
            ans += right - left + 1;
            right++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
