package org.example.stack;

import java.util.Stack;

/**
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class ValidateStackSequences {

    /**
     * 验证栈操作序列
     *
     * @param pushed pushed序列
     * @param popped popped序列
     * @return 是否可以通过栈操作生成popped序列
     * 算法思路：
     * 1、使用一个栈来模拟pushed的入栈和poped的出栈操作
     * 2、遍历pushed数组，将元素一次压入栈中
     * 3、每次入栈检查栈顶是否等于poped当前指针指向的值
     * 4、如果相等，则将栈顶弹出，同时移动popped指针
     * 5、最后检查栈是否为空，如果为空，说明序列有效，否则序列无效
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();// 模拟栈
        int popIndex = 0;// popped数组的指针
        for (int num : pushed) {
            stack.push(num);// 当前元素入栈
            System.out.println("Push: " + num + ", Stack: " + stack);

            // 检查栈顶是否等于 popped 当前指向的值
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                System.out.println("Pop: " + stack.peek() + " matches popped[" + popIndex + "] = " + popped[popIndex]);
                stack.pop();//弹出栈顶元素
                popIndex++;//移动popped指针
            }
        }
        // 如果栈为空，则序列是有效的，否则无效
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
