package org.example.string.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * 计算字符串中无重复字符的最长子串的长度
     * 核心思路：通过滑动窗口方法，使用哈希集合来存储窗口内的字符，确保子串中没有重复字符。
     * 使用两个指针 `left` 和 `right` 来表示当前窗口的左右边界。
     *
     * @param s 输入字符串
     * @return 无重复字符的最长子串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        // 初始化左右指针
        int left = 0;
        int right = 0;
        // 无重复字符的最长子串的长度
        int maxLength = 0;
        // 用来存储当前窗口的字符
        Set<Character> window = new HashSet<>();

        // 遍历字符串
        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果c不在窗口，扩展窗口
            if (!window.contains(c)) {
                window.add(c);// 加入当前字符到窗口
                right++;// 右指针右移
                maxLength = Math.max(maxLength, right - left);// 更新最大长度
            }
            // 遇到重复字符，收缩窗口
            else {
                window.remove(s.charAt(left));// 移除最左边字符
                left++;// 左指针右移
            }
        }
        // 返回无重复字符的最长子串的长度
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1 + ", Output: " + lengthOfLongestSubstring(s1)); // 输出 3

        String s2 = "bbbbb";
        System.out.println("Input: " + s2 + ", Output: " + lengthOfLongestSubstring(s2)); // 输出 1

        String s3 = "pwwkew";
        System.out.println("Input: " + s3 + ", Output: " + lengthOfLongestSubstring(s3)); // 输出 3
    }
}
