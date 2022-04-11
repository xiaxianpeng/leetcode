package org.example.array;

import java.util.Arrays;

/**
 * @author xianpeng.xia
 * on 2022/4/11 2:10 PM
 *
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class RotateArray {

    /**
     * @param nums num
     * 使用额外的数组
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArray = new int[n];
        //
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, n);
    }

    /**
     * @param nums nums
     * @param k k
     *
     * 该方法基于如下的事实：当我们将数组的元素向右移动 k 次后，尾部 k mod n 个元素会移动至数组头部，其余元素向后移动 k mod n 个位置。
     *
     * 该方法为数组的翻转：
     * 我们可以先将所有元素翻转，这样尾部的 k mod n 个元素就被移至数组头部，
     * 然后我们再翻转 [0,(k mod n) - 1][0,(k mod n) − 1] 区间的元素和 [(k mod n), n-1][(k mod n),n−1] 区间的元素即能得到最后的答案。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void rotateArray(int[] nums, int k) {
        k %= nums.length;

        // 翻转所有元素
        reverse(nums, 0, nums.length - 1);
        // 翻转[0,k mod n−1] 区间的元素
        reverse(nums, 0, k - 1);
        // 翻转[k mod n,n−1] 区间的元素
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(nums));
        rotateArray(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
