package org.example.slidingwindow.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
     * 使用滑动窗口的算法来查找无重复字符的最长子串的长度
     *
     * @param s 字符串
     * @return 无重复字符的最长子串长度
     * 算法思路：
     * 1、使用两个指针left和right表示当前窗口的左右边界
     * 2、使用一个哈希映射来记录字符上一次出现的位置
     * 3、遍历字符串，当遇到重复字符时，移动left指针到重复字符上一次出现的位置下一个位置
     * 4、更新最长子串的长度
     */
    public static int lengthOfLongestSubstring(String s) {

        // 哈希映射，存储字符及其在字符串中的最新索引
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // 初始化左指针和最长长度
        int left = 0; // 滑动窗口的左边界
        int maxLength = 0; // 最长无重复字符子串的长度

        // 遍历字符串中的每个字符
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            System.out.println("当前字符: " + currentChar);
            // 如果当前字符已存在与哈希映射中，并且其索引不小于左指针(避免重复)，调整左边界
            if (charIndexMap.containsKey(currentChar)) {
                // 更新左指针到重复字符的下一个位置
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
                System.out.printf("重复字符 '%c' 出现，窗口左边界移动到索引 %d\n", currentChar, left);
            }
            // 更新当前字符串的最新索引
            charIndexMap.put(currentChar, right);
            // 计算当前窗口的长度，并更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
            System.out.printf("添加字符 '%c'，窗口范围 [%d, %d]，当前最长长度: %d\n", currentChar, left, right, maxLength);
        }
        return maxLength;
    }

    /**
     * 计算字符串中无重复字符的最长子串的长度
     * 核心思路：通过滑动窗口方法，使用哈希集合来存储窗口内的字符，确保子串中没有重复字符。
     * 使用两个指针 `left` 和 `right` 来表示当前窗口的左右边界。
     *
     * @param s 输入字符串
     * @return 无重复字符的最长子串长度
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 初始化左右指针
        int left = 0;
        int right = 0;
        // 无重复字符的最长子串的长度
        int maxLength = 0;
        // 当前窗口中的唯一字符集合
        Set<Character> window = new HashSet<>();

        // 遍历字符串
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            // 如果不在窗口，添加它到集合并向右扩展窗口
            if (!window.contains(currentChar)) {
                window.add(currentChar);// 加入当前字符到窗口
                right++;// 右指针右移
                maxLength = Math.max(maxLength, right - left);// 更新最大长度
                System.out.println("添加: " + currentChar + "，窗口扩展至: " + s.substring(left, right));
            }
            // 遇到重复字符，移除窗口最左边的字符
            else {
                System.out.println("遇到重复字符: " + currentChar + "，移除: " + s.charAt(left) + "，并缩小窗口");
                window.remove(s.charAt(left));// 移除最左边字符
                left++;// 左指针右移，以缩小窗口
            }
        }
        // 返回无重复字符的最长子串的长度
        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // 输出 3
        //System.out.println(lengthOfLongestSubstring2(s1)); // 输出 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // 输出 1
        //System.out.println(lengthOfLongestSubstring2(s2)); // 输出 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // 输出 3
        //System.out.println(lengthOfLongestSubstring2(s3)); // 输出 3
    }
}
