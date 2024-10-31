package org.example.stack;

import org.example.stack.structure.ArrayStack;

/**
 * @date 2021/01/18
 * @time 16:22
 * 题目: https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
