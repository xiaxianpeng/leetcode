package org.example.string;

import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/6 9:15 PM
 *
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {

    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        // 存数字
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        char[] chars = s.toCharArray();
        // 倍数
        int multi = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {// 如果是数字
                multi = Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {// 如果是[
                ansStack.add(ans);
                multiStack.add(multi);
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {// 如果是字母
                ans.append(c);
            } else {// 如果是]
                StringBuffer ansTemp = ansStack.pop();
                int multiTemp = multiStack.pop();
                for (int a = 0; a < multiTemp; a++) {
                    ansTemp.append(ans);
                }
                ans = ansTemp;
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        String decodeString = decodeString(s);
        System.out.println(s);
        System.out.println(decodeString);
    }

}
