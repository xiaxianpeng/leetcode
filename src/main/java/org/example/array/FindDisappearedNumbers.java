package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xianpeng.xia
 * on 2022/4/6 11:30 PM
 *
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 *
 * 提示：
 *
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
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) / n;
            nums[x] = nums[x] + n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}
