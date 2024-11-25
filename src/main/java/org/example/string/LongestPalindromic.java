package org.example.string;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的子串
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindromic {

    /**
     * 使用中心扩展法寻找最长回文子串。
     * 思路：
     * - 遍历字符串的每个字符，尝试以当前字符为中心或者字符间隙为中心扩展。
     * - 记录并更新最长的回文子串。
     *
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的回文子串（奇数长度）
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的回文子串（偶数长度）
            String s2 = palindrome(s, i, i + 1);

            // 更新最长回文子串
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;
    }

    /**
     * 中心扩展法。
     * 从指定中心位置向两侧扩展，寻找最长的回文子串。
     *
     * @param s 输入字符串
     * @param L 左指针
     * @param R 右指针
     * @return 从中心扩展找到的最长回文子串
     */
    public static String palindrome(String s, int L, int R) {
        // 当左右指针都在范围内且字符相等时扩展
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            // 双指针展开
            L--;
            R++;
        }

        // 返回以s[L] 和 s[R] 为中心的最长回文串
        return s.substring(L + 1, R);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // 输出: "bab" 或 "aba"
        System.out.println(longestPalindrome("cbbd"));  // 输出: "bb"
        System.out.println(longestPalindrome("a"));     // 输出: "a"
        System.out.println(longestPalindrome("ac"));    // 输出: "a" 或 "c"
    }
}
