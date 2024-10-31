package org.example.stack;

import org.example.stack.structure.ArrayStack;

/**
 * @date 2021/01/18
 * @time 16:22
 * 题目: https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (!matched(topChar, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isLeft(Character c) {
        return c.equals('{') || c.equals('[') || c.equals('(');
    }

    public static boolean isRight(Character c) {
        return c.equals('}') || c.equals(']') || c.equals(')');
    }

    public static boolean matched(Character left, Character right) {
        if (left.equals('{')) {
            return right.equals('}');
        }
        if (left.equals('[')) {
            return right.equals(']');
        }
        if (left.equals('(')) {
            return right.equals(')');
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValid(s));

        s = "{[()]]";
        System.out.println(isValid(s));
    }
}
