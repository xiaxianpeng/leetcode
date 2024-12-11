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

    /**
     * 算法思路：
     * 1. 使用一个长度为26的频率数组统计字符串中每个字符的出现次数。
     * 2. 再次遍历字符串，找到第一个频率为1的字符，返回其索引。
     * 3. 如果没有找到这样的字符，返回 -1。
     */
    public static int firstUniqueChar(String s) {
        int[] freq = new int[26];
        // 第一次遍历，统计每个字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        // 第二次遍历，查找频率为1的字符
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
