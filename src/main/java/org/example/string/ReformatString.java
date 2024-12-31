package org.example.string;

/**
 * 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。
 * 也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；
 * 如果无法按要求重新格式化，则返回一个 空字符串 。
 * 示例 1：
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 * 示例 3：
 * 输入：s = "1229857369"
 * 输出：""
 * 解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
 * 示例 4：
 * 输入：s = "covid2019"
 * 输出："c2o0v1i9d"
 * 示例 5：
 * 输入：s = "ab123"
 * 输出："1a2b3"
 * Created on 2024/12/31 09:56
 */
public class ReformatString {

    /**
     * 重新格式化字符串
     *
     * @param s 原始字符串
     * @return 重新格式化后的字符串，或空字符串
     * 算法思路：
     * 先将字符串的数字和字母分离
     * 分别存入不同的容器中，然后交替拼接数字和字母
     * 确保相邻字符类型不同，如果无法满足，则返回空字符串
     */
    public static String reformat(String s) {

        // 将数字和字母分别存储
        StringBuffer digits = new StringBuffer();
        StringBuffer letters = new StringBuffer();

        // 遍历字符串，区分数字和字母
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                letters.append(c);
            }
        }

        // 如果两者之差大于1，则无法组成符合条件的字符串
        if (Math.abs(digits.length() - letters.length()) > 1) {
            return "";
        }

        // 确定哪个作为开头
        StringBuffer longer = digits.length() >= letters.length() ? digits : letters;
        StringBuffer shorter = digits.length() < letters.length() ? digits : letters;

        // 重新组装结果
        StringBuffer result = new StringBuffer();
        int i = 0;
        int j = 0;
        // 交替拼接
        while (i < longer.length() || j < shorter.length()) {
            if (i < longer.length()) {
                result.append(longer.charAt(i));
                i++;
            }
            if (j < shorter.length()) {
                result.append(shorter.charAt(j));
                j++;
            }
        }

        // 返回结果
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));    // "0a1b2c" 或其他满足条件的组合
        System.out.println(reformat("leetcode"));  // ""
        System.out.println(reformat("1229857369"));// ""
        System.out.println(reformat("covid2019")); //  "c2o0v1i9d"
        System.out.println(reformat("ab123"));     // "1a2b3" 或其他满足条件的组合
    }
}
