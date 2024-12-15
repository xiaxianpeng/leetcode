package org.example.string;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * Created on 2024/12/15 11:46
 */
public class PalindromeSubstrings {

    /**
     * 使用中心扩展算法来计算回文子串的数量
     * 对于每个可能的回文中心(单字符和双字符中心)，向两边扩展，直到不再形成回文
     *
     * @param s 输入字符串
     * @return 回文子串长度
     */
    private static int countSubstrings(String s) {
        int totalCount = 0;
        if (s == null || s.length() == 0) {
            return totalCount;
        }
        for (int i = 0; i < s.length(); i++) {
            // 单字符中心
            totalCount += countPalindromes(s, i, i);
            // 双字符中心
            totalCount += countPalindromes(s, i, i + 1);
        }
        return totalCount;
    }

    /**
     * 从给定中心向两边扩展，并计算形成的回文子串数量
     *
     * @param s     字符串
     * @param left  中心左边界
     * @param right 中心有边界
     * @return 从当前中心扩展形成的回文子串数量
     */
    private static int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            // 每次扩展发现回文时，回文子串计数增加
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));// 3
        System.out.println(countSubstrings("aaa"));// 6
    }
}
