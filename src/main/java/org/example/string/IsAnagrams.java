package org.example.string;

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
     * 判断两个字符串是否是字母异位词。
     * 核心思路：使用固定大小的计数数组记录每个字母出现的频次。
     * - 遍历字符串 s 时，对对应字母频次增加。
     * - 遍历字符串 t 时，对对应字母频次减少。
     * - 如果最终计数数组中所有值均为 0，表示两个字符串互为字母异位词。
     *
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 如果 t 是 s 的字母异位词，返回 true；否则返回 false。
     */
    public static boolean isAnagram(String s, String t) {
        // 如果两个字符串长度不同，则不可能是字母异位词
        if (s.length() != t.length()) {
            return false;
        }
        // 用于记录每个字母的出现频次
        int[] charFrequency = new int[26];

        // 遍历字符串 s 和 t，更新字母频次
        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;// 对 s 中的字符计数加 1
            charFrequency[t.charAt(i) - 'a']--;// 对 t 中的字符计数减 1
        }

        // 检查计数数组中是否所有值均为 0
        for (int i = 0; i < charFrequency.length; i++) {
            if (charFrequency[i] != 0) {
                return false;// 如果存在非 0 的值，说明两字符串频次不同
            }
        }
        // 所有计数均为 0，表示是字母异位词
        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(isAnagram("anagram", "nagaram")); // 输出: true
        System.out.println(isAnagram("rat", "car"));         // 输出: false
        System.out.println(isAnagram("", ""));               // 输出: true
        System.out.println(isAnagram("a", "ab"));            // 输出: false
    }
}
