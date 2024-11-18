package org.example.linkedList.twopointers;

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

    public static String longestPalindrome(String s) {
        // 用于保存找到的最长回文子串
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 以字符 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以字符 s[i] 和 s[i+1] 为中心的最长回文子串，适用于偶数长度的回文
            String s2 = palindrome(s, i, i + 1);
            // 更新 ans 为最长的回文子串
            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        // 返回找到的最长回文子串
        return ans;
    }

    public static String palindrome(String s, int left, int right) {
        // 当 L 和 R 指向的字符相同且没有越界时，向两边扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为跳出循环时，L 和 R 指向的字符不同，所以实际的回文串是从 L+1 到 R-1 位置的子串
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println("babad" + " : " + longestPalindrome("babad"));
        System.out.println("cbbd" + " : " + longestPalindrome("cbbd"));
    }
}
