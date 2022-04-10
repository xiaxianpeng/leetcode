package org.example.string;

/**
 * @author xianpeng.xia
 * on 2022/4/8 11:07 AM
 *
 * 回文子字符串的个数
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 链接：https://leetcode-cn.com/problems/a7VOhD
 */
public class CountPalindromeSubstring {

    /**
     * 遍历字符串，对每个字符，都看作回文的中心，
     * 向两端延申进行判断直到非回文。
     *
     * 回文的中心可能是一个字符，也可能是两个字符。
     *
     * @return 回文数
     * https://leetcode-cn.com/problems/a7VOhD/solution/jian-zhi-offer-zhuan-xiang-tu-po-ban-gua-6bln/
     */
    public static int countSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        // 字符串的每个字符都作为回文中心进行判断，中心是一个或者两个字符
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }

    /**
     * @param s 字符串
     * @param start 开始位置
     * @param end 结束位置
     * 比较是否为回文并计数
     */
    private static int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubString(s));
    }
}
