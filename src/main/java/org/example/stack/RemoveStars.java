package org.example.stack;

import java.util.Stack;

/**
 * 2390. 从字符串中移除星号
 * 给你一个包含若干星号 * 的字符串 s 。
 * 在一步操作中，你可以：
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 * 注意：
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 * Created on 2024/11/18 12:00
 */
public class RemoveStars {
    /**
     * 算法思路：
     * 1. 使用栈来模拟从字符串中移除星号的过程。
     * 2. 遍历字符串，对于每个字符：
     * - 如果是非星号字符，则将该字符加入栈中。
     * - 如果是星号字符，则移除栈顶的字符（即移除该字符左侧最近的非星号字符）。
     * 3. 最终栈中保存的就是移除星号后的结果。
     * 时间复杂度：O(n)，其中 n 是字符串的长度。我们遍历了字符串一次，操作栈的时间复杂度为 O(1)。
     * 空间复杂度：O(n)，需要栈来存储字符串中的字符。
     */
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        // 遍历字符串
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // 遇到星号，弹出栈顶元素
                stack.pop();
            } else {
                // 遇到非星号字符，压入栈中
                stack.push(c);
            }
        }
        // 利用 StringBuilder 来构造最终结果
        StringBuffer sb = new StringBuffer();
        // 从栈底到栈顶依次取出字符，构建最终字符串
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 因为栈是后进先出(LIFO)，所以需要将结果反转
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e")); // 输出："lecoe"
        System.out.println(removeStars("a*bc*d"));       // 输出："bd"
    }
}
