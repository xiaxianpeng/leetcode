package org.example.twopointers.string;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码？
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class IsSubsequence {

    /**
     * 判断子序列：使用双指针遍历两个字符串，依次匹配字符。
     * 核心思路：
     * 1. 使用两个指针 i 和 j，分别遍历字符串 s 和 t。
     * 2. 如果 s[i] 等于 t[j]，则移动 i 和 j；否则只移动 j。
     * 3. 当 i 遍历完 s 时，说明 s 是 t 的子序列。
     * 时间复杂度：O(n + m)，其中 n 是 s 的长度，m 是 t 的长度。
     * 空间复杂度：O(1)。
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        // 遍历 t 直到 s 被完全匹配或 t 遍历结束
        while (i < s.length() && j < t.length()) {
            // 如果字符匹配，移动 s 的指针
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // 无论是否匹配，都移动 t 的指针
            j++;
        }
        // 如果 i 遍历完整个 s，则说明 s 是 t 的子序列
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // 输出：true
        System.out.println(isSubsequence("axc", "ahbgdc")); // 输出：false
        System.out.println(isSubsequence("", "ahbgdc"));    // 输出：true
    }
}
