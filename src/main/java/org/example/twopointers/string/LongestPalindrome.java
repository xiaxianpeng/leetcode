package org.example.twopointers.string;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的
 * 回文
 * 子串
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * Created on 2024/11/11 19:35
 */
public class LongestPalindrome {

    /**
     * 寻找最长回文子串
     * 核心思路：使用中心扩展法，以每个字符或相邻字符对为中心向两边扩展，检查回文子串的长度。
     * 比较每个中心扩展的回文子串，记录最长的回文子串。
     *
     * @param s 输入的字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        // 判断特殊情况 // 如果输入为空字符串，直接返回
        if (s == null || s.length() == 0) {
            return "";
        }

        // 用于保存找到的最长回文子串
        String ans = "";
        // 遍历每个字符，以它为中心扩展
        for (int i = 0; i < s.length(); i++) {
            // 扩展回文的中心，i是回文的中心，分为两种情况：
            // 1. 回文中心是单个字符：s[i]
            // 2. 回文中心是两个相同字符：s[i] 和 s[i + 1]
            String s1 = palindrome(s, i, i); // 以s[i]为中心
            String s2 = palindrome(s, i, i + 1);// 以s[i]和s[i + 1]为中心
            // 更新 ans 为最长的回文子串
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        // 返回找到的最长回文子串
        return ans;
    }

    /**
     * 从给定的中心扩展回文子串
     *
     * @param s     输入的字符串
     * @param left  左边的起始位置
     * @param right 右边的起始位置
     * @return 从中心扩展得到的回文子串的长度
     */
    public static String palindrome(String s, int left, int right) {
        // 当 L 和 R 指向的字符相同且没有越界时，向两边扩展
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 扩展结束时，返回的回文子串的长度
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println("babad" + " : " + longestPalindrome("babad"));
        System.out.println("cbbd" + " : " + longestPalindrome("cbbd"));
    }
}
