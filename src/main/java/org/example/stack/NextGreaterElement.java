package org.example.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，
 * 下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，
 * 找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
 * 如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 * Created on 2024/11/14 23:16
 */
public class NextGreaterElement {

    /**
     * 使用单调栈和哈希表来预处理nums2中每个元素的下一个更大元素，然后根据nums1返回结果
     *
     * @param nums1 子集
     * @param nums2 主数组
     * @return 返回每个子集在nums2中的下一个更大元素组成的数组
     * 算法思路：
     * 1、遍历nums2，使用栈来维护一个单调递减的序列
     * 2、对于每个元素，如果当前元素大于栈顶元素，则将栈顶元素的下一个更大元素设为当前元素，并将栈顶弹出
     * 3、将当前元素压入栈中
     * 4、最终，栈中剩余的元素在nums2中没有更大元素，设为-1；
     * 5、遍历nums1，通过哈希表获取对应的下一个更大元素
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 创建一个栈来存储可能的下一个更大元素
        Stack<Integer> stack = new Stack<>();
        // 创建一个哈希表来存储nums2中每个元素的下一个更大元素
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        // 遍历 nums2 并使用单调栈找到每个元素的下一个更大元素
        for (int num : nums2) {
            System.out.println("当前处理的元素: " + num);
            // 如果当前元素大于栈顶元素，则更新哈希表
            while (!stack.isEmpty() && num > stack.peek()) {
                Integer prev = stack.pop();
                nextGreaterMap.put(prev, num);
                System.out.println("元素 " + prev + " 的下一个更大元素是 " + num);
            }
            // 将当前元素压入栈中
            stack.push(num);
            System.out.println("元素 " + num + " 被压入栈中，当前栈: " + stack);
        }

        // 对于栈中剩余的元素，没有下一个更大元素
        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            nextGreaterMap.put(popped, -1);
            System.out.println("元素 " + popped + " 没有下一个更大元素，设为 -1");
        }

        System.out.println("下一个更大元素的映射关系：");
        System.out.println(nextGreaterMap);

        // 遍历nums1，通过哈希表获取对应的下一个更大元素
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
            System.out.println("元素 " + nums1[i] + " 的下一个更大元素是 " + result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
