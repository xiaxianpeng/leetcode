package org.example.greedy;

import java.util.Stack;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的
 * 字典序
 * 最小（要求不能打乱其他字符的相对位置）。
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * https://leetcode.cn/problems/remove-duplicate-letters/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/12 17:36
 */
public class RemoveDuplicateLetters {

    //该算法的关键是要理解如何贪心地构建一个在字典序下尽可能小的字符串，同时保证每个字母只出现一次，并且维持原字符串中字母的相对顺序。具体算法如下：
    //初始化：使用栈来保存构建的字符串，贪心地保证栈顶到栈底的字母顺序最小。使用计数器 count 记录每个字符在字符串中出现的次数，使用 inStack 数组标记字符是否在栈中。
    //遍历：遍历输入字符串 s 中的每个字符 c。如果 c 已经在栈中，跳过当前循环，因为我们要保持字符的唯一性。否则，执行下一步。
    //栈操作：比较当前字符 c 与栈顶字符。如果栈顶字符大于 c 且栈顶字符在后续的字符串中还会出现（由 count 数组检查），则弹出栈顶字符并更新 inStack 数组。
    //这一步是贪心的，因为它尽可能地保持栈（字符串）的字典序小。
    //压栈：将当前字符 c 压入栈中，并在 inStack 数组中标记为已入栈。
    //构建结果：由于采用栈结构，最终字符序列是逆序的。需要对栈中的字符序列进行反转，得到最终的结果字符串。
    public static String removeDuplicateLetters(String s) {
        // 栈用来保存最终结果中的字符序列
        Stack<Character> stack = new Stack<>();
        // 计数器，记录每个字符在剩余字符串中出现的次数，大小 256 用于存储 ASCII 字符
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        // inStack 数组用于标记字符是否在栈中
        boolean[] inStack = new boolean[256];

        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 每遍历过一个字符，减少其计数
            count[c]--;
            // 如果字符已经存在于栈中，则跳过这个字符，因为不需要重复
            if (inStack[c]) {
                continue;
            }
            // 当前字符小于栈顶字符，且栈顶字符在后续字符串中还会出现
            // 可以移除栈顶字符以获取更小字典序
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()] > 0) {
                inStack[stack.pop()] = false;
            }
            // 将当前字符压入栈，并标记为已存在
            stack.push(c);
            inStack[c] = true;
        }
        // 使用 StringBuffer 构建结果字符串
        // 由于使用了栈，最终得到的字符序列是逆序的，需要反转得到正确的顺序
        StringBuffer ans = new StringBuffer();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        // 反转字符序列
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));// abc
        System.out.println(removeDuplicateLetters("cbacdcbc"));// acdb
    }
}
