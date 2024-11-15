package org.example.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * 示例 1:
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 链接：https://leetcode.cn/problems/next-greater-element-ii/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/15 11:01
 */
public class NextGreaterElement2 {

    /**
     * 算法思路如下：
     * 1、创建一个结果数组 ans 并初始化所有元素为 -1，这样在最终结果中未修改的元素说明没有找到下一个更大的元素。
     * 2、使用一个栈 stack 来维护一个索引序列，这些索引对应的数组 nums 中的元素值是保持单调递减的。
     * 3、遍历数组 nums 两次来模拟循环数组的效果。因为数组是循环的，所以一个元素的下一个更大元素有可能在它前面。
     * 4、在每次遍历过程中，如果当前元素 nums[index] 大于栈顶元素索引指向的元素值 nums[stack.peek()]，
     * 则说明我们找到了栈顶索引指向的元素的下一个更大元素，即当前元素。我们将结果记录在 result 数组中，并且将栈顶索引弹出。
     * 5、在第一次遍历时，将遍历到的元素索引入栈，以待后续比较。第二次遍历时不再将索引入栈，因为已经比较过一次。
     * 6、第二次遍历完成后，栈中剩余的索引对应的元素在数组 nums 中没有找到下一个更大的元素，它们在结果数组 result 中的值依然是 -1。
     * 7、最后返回结果数组 ans。
     */
    public static int[] nextGreaterElements(int[] nums) {
        // 结果数组，初始值设为 -1 表示没有找到下一个更大元素
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        // 使用栈来维护一个索引，这些索引对应的元素是单调递减的
        Stack<Integer> stack = new Stack<>();

        // 遍历两倍长度的数组，第二次遍历是为了模拟循环数组的效果
        for (int i = 0; i < nums.length * 2; i++) {
            // 使用取模操作得到实际的数组索引
            int index = i % nums.length;
            // 当栈非空，并且当前元素大于栈顶索引所指向的元素时
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                // 当前元素是栈顶索引所指向元素的下一个更大元素
                Integer prevIndex = stack.pop();
                ans[prevIndex] = nums[index];
                System.out.println("元素 " + nums[prevIndex] + "（索引 " + prevIndex + "）的下一个更大元素是 " + nums[index]);
            }
            // 如果在第一轮遍历内（即 i < n），将索引推入栈中
            // 第二轮遍历不再推入索引，因为我们不需要重复考虑已经处理过的元素
            if (i < nums.length) {
                stack.push(index);
                System.out.println("将元素 " + nums[index] + "（索引 " + index + "）推入栈中");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输出为 [2, -1, 2]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        // 输出为 [2, 3, 4, -1, 4]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}
