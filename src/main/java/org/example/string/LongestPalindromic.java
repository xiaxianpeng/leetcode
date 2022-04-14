package org.example.string;

/**
 * @author xianpeng.xia
 * on 2021/3/18 8:28 上午
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 *
 * 最长回文子串
 */
public class LongestPalindromic {

    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 以s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以s[i] 和 s[1+!] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            ans = ans.length() > s1.length() ? ans : s1;
            ans = ans.length() > s2.length() ? ans : s2;
        }
        return ans;
    }

    public static String palindrome(String s, int L, int R) {
        // 防止索引越界
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            // 双指针展开
            L--;
            R++;
        }

        // 返回以s[L] 和 s[R] 为中心的最长回文串
        return s.substring(L + 1, R);
    }

    public static String solution(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }
}
