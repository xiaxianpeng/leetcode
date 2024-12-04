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
     * 判断 s 是否为 t 的子序列
     * 算法思路：
     * 使用双指针的方法，遍历字符串 s 和 t。
     * 如果 s 的字符在 t 中按顺序找到匹配，则返回 true，否则返回 false。
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return true 如果 s 是 t 的子序列，否则 false
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0;// 指向 s 的指针
        int j = 0;// 指向 t 的指针

        // 遍历 t，当 i 小于 s 的长度时
        while (i < s.length() && j < t.length()) {
            // 如果 s[i] 和 t[j] 匹配，指针 i 向前移动
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            // 无论是否匹配，指针 j 向前移动
            j++;
        }

        // 如果 i == s.length(), 说明所有字符都匹配上了
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // 输出：true
        System.out.println(isSubsequence("axc", "ahbgdc")); // 输出：false
        System.out.println(isSubsequence("", "ahbgdc"));    // 输出：true
    }
}
