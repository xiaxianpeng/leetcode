package org.example.string.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
 * 返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAnagrams {

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，
     * 返回这些子串的起始索引
     *
     * @param s 主字符串
     * @param p 字符串 p，其异位词子串为目标
     * @return 含有所有起始索引的列表
     */
    public static List<Integer> findAnagrams(String s, String p) {
        // need 用来存储字符串 p 中每个字符的期望出现次数。
        Map<Character, Integer> need = new HashMap<>();
        // 初始化 need 哈希表，用于存储字符串 p 中每个字符及其出现的次数。
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // window 用来存储当前滑动窗口中各字符的实际出现次数。
        Map<Character, Integer> window = new HashMap<>();

        // left 和 right 分别代表滑动窗口的左右边界指针。
        int left = 0;
        int right = 0;
        // valid 变量用来记录窗口中满足 need 条件的字符数量。
        int valid = 0;
        // anagramStarts 用来存储所有异位词的起始索引。
        List<Integer> anagramStarts = new ArrayList<>();

        // 开始遍历主字符串 s。
        while (right < s.length()) {
            // c 是即将移入窗口的字符。
            char c = s.charAt(right);
            right++;// 扩大窗口。

            // 进行窗口内数据的更新，记录字符 c 的出现次数。
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果字符 c 的出现次数符合期望，增加 valid 计数。
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 窗口大小 大于或等于 p 的长度时，开始收缩左边界。
            while (right - left >= p.length()) {
                // 如果窗口内的字符完全符合 need，记录当前 left 索引。
                if (valid == need.size()) {
                    anagramStarts.add(left);
                }

                // d 是即将移出窗口的字符。
                char d = s.charAt(left);
                left++;// 缩小窗口。

                // 进行窗口内数据的更新，移除字符 d 的出现次数。
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        // 如果字符 d 的出现次数符合期望，减少 valid 计数。
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }
        }

        // 返回所有异位词的起始索引。
        return anagramStarts;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
