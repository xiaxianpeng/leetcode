package org.example.array.hash;

/**
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 */
public class FirstUniqueChar {

    public static int firstUniqueChar(String s) {
        int[] freq = new int[26];
        // 遍历字符串统计字符频次
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // 遍历字符串找到字符频次为1的索引
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqueChar(s));
    }
}
