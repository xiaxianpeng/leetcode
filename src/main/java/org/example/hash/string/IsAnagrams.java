package org.example.hash.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class IsAnagrams {

    /**
     * 判断 t 是否是 s 的字母异位词
     * 核心思路：
     * - 通过字符频次判断两个字符串是否相同。
     * - 用一个哈希表统计 s 中每个字符的频次，然后遍历 t 减少对应字符的频次。
     * - 最后检查所有字符频次是否为 0。
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 如果 t 是 s 的字母异位词返回 true，否则返回 false
     */
    public static boolean isAnagram(String s, String t) {
        // 如果两个字符串长度不同，则不可能是字母异位词
        if (s.length() != t.length()) {
            return false;// 长度不同，直接返回 false
        }
        // 创建一个哈希表统计字符频次
        Map<Character, Integer> charCount = new HashMap<>();

        // 遍历 s，增加每个字符的频次
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 遍历 t，减少每个字符的频次
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        }

        // 检查所有频次是否为 0
        for (Character c : charCount.keySet()) {
            if (charCount.get(c) > 0) {
                return false;
            }
        }

        // 所有计数均为 0，表示是字母异位词
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // 输出: true
        System.out.println(isAnagram("rat", "car"));         // 输出: false
        System.out.println(isAnagram("", ""));               // 输出: true
        System.out.println(isAnagram("a", "ab"));            // 输出: false
    }
}
