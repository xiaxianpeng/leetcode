package org.example.stack;


import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * 输入：s = "([])"
 * 输出：true
 */
public class ValidParentheses {

    /**
     * 判断括号是否有效
     * 思路：
     * 1. 使用栈来存储左括号。
     * 2. 遍历字符串，遇到左括号将其压入栈中。
     * 3. 遇到右括号时，检查栈顶元素是否与当前右括号匹配。
     * 4. 最后，栈为空表示所有括号都匹配，返回 true，否则返回 false。
     *
     * @param s 输入字符串
     * @return 返回布尔值，若括号有效则返回 true，否则返回 false
     */
    public static boolean isValid(String s) {
        // 创建一个栈来存储左括号
        Stack<Character> stack = new Stack<>();
        // 遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是左括号，则压入栈
            if (isLeft(c)) {
                stack.push(c);
            }
            // 如果是右括号，检查栈顶是否为对应的左括号
            else {
                // 栈为空时，表示没有左括号匹配，返回 false
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();// 弹出栈顶元素
                // 判断栈顶的左括号是否与当前的右括号匹配
                if (!matched(topChar, c)) {
                    return false;
                }
            }
        }

        // 如果栈为空，说明所有的括号都匹配完成，返回 true；否则返回 false
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
        System.out.println(isValid("()"));        // 输出 true
        System.out.println(isValid("()[]{}"));    // 输出 true
        System.out.println(isValid("(]"));        // 输出 false
        System.out.println(isValid("([])"));      // 输出 true
    }
}
